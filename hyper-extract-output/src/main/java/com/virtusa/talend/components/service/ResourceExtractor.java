package com.virtusa.talend.components.service;

import com.virtusa.talend.components.App;
import com.virtusa.talend.components.processor.HyperOutputProcessor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ResourceExtractor {

    private static final String TESTCONTAINERS_TMP_DIR_PREFIX = "testcontainers-tmp-";
    public static final String OS_MAC_TMP_DIR = "/tmp";
    private static final String os = System.getProperty("os.name");

    /**
     * Extract a file or directory tree from a JAR file to a temporary location.
     * This allows Docker to mount classpath resources as files.
     *
     * @param hostPath the path on the host, expected to be of the format 'file:/path/to/some.jar!/classpath/path/to/resource'
     * @return the path of the temporary file/directory
     */
    public String extractClassPathResourceToTempLocation(final String hostPath) {
        File tmpLocation = createTempDirectory();
        //noinspection ResultOfMethodCallIgnored
        tmpLocation.delete();

        String urldecodedJarPath = unencodeResourceURIToFilePath(hostPath);
        String internalPath = hostPath.replaceAll("[^!]*!/", "");

        try (JarFile jarFile = new JarFile(urldecodedJarPath)) {
            Enumeration<JarEntry> entries = jarFile.entries();

            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                final String name = entry.getName();
                if (name.startsWith(internalPath)) {
                    System.out.println("Copying classpath resource(s) from {"+hostPath+"} to {"+tmpLocation+"}");
                    copyFromJarToLocation(jarFile, entry, internalPath, tmpLocation);
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("Failed to process JAR file when extracting classpath resource: " + hostPath, e);
        }

        // Mark temporary files/dirs for deletion at JVM shutdown
        deleteOnExit(tmpLocation.toPath());

        return tmpLocation.getAbsolutePath();
    }

    private static String unencodeResourceURIToFilePath(final String resource) {
        try {
            // Convert any url-encoded characters (e.g. spaces) back into unencoded form
            return URLDecoder.decode(resource, "UTF-8")
                    .replaceFirst("jar:", "")
                    .replaceFirst("file:", "")
                    .replaceAll("!.*", "");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private File createTempDirectory() {
        try {
            if (isMac()) {
                return Files.createTempDirectory(Paths.get(OS_MAC_TMP_DIR), TESTCONTAINERS_TMP_DIR_PREFIX).toFile();
            }
            return Files.createTempDirectory(TESTCONTAINERS_TMP_DIR_PREFIX).toFile();
        } catch  (IOException e) {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String generatedString = new String(array, Charset.forName("UTF-8"));
            return new File(TESTCONTAINERS_TMP_DIR_PREFIX + generatedString);
        }
    }

    private void copyFromJarToLocation(final JarFile jarFile,
                                       final JarEntry entry,
                                       final String fromRoot,
                                       final File toRoot) throws IOException {

        String destinationName = entry.getName().replaceFirst(fromRoot, "");
        File newFile = new File(toRoot, destinationName);

        System.out.println("Copying resource {"+fromRoot+"} from JAR file {"+jarFile.getName()+"}");

        if (!entry.isDirectory()) {
            // Create parent directories
            Path parent = newFile.getAbsoluteFile().toPath().getParent();
            parent.toFile().mkdirs();
            newFile.deleteOnExit();

            try (InputStream is = jarFile.getInputStream(entry)) {
                Files.copy(is, newFile.toPath());
            } catch (IOException e) {
                System.out.println("Failed to extract classpath resource " + entry.getName() + " from JAR file " + jarFile.getName()+":"+ e);
                throw e;
            }
        }
    }

    private void deleteOnExit(final Path path) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> recursiveDeleteDir(path)));
    }

    /**
     * Recursively delete a directory and all its subdirectories and files.
     *
     * @param directory path to the directory to delete.
     */
    public static void recursiveDeleteDir(Path directory) {
        try {
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException ignored) {
        }
    }

    private String getOSName(){
        if(os.startsWith("Windows")){
            return "windows";
        }else if(os.startsWith("Linux")){
            return  "linux";
        }else if(os.startsWith("Mac")){
            return "macos";
        }
        return null;
    }

    private boolean isWindows(){
        return getOSName() == "Windows";
    }

    private boolean isMac(){
        return getOSName() == "Mac";
    }

    private boolean isLinux(){
        return getOSName() == "Linux";
    }

    public static URL getClasspathResource(final String resourcePath, final Set<ClassLoader> classLoaders) {

        final Set<ClassLoader> classLoadersToSearch = new HashSet<>(classLoaders);
        // try context and system classloaders as well
        classLoadersToSearch.add(Thread.currentThread().getContextClassLoader());
        classLoadersToSearch.add(ClassLoader.getSystemClassLoader());
        classLoadersToSearch.add(HyperOutputProcessor.class.getClassLoader());

        for (final ClassLoader classLoader : classLoadersToSearch) {
            URL resource = classLoader.getResource(resourcePath);
            if (resource != null) {
                return resource;
            }

            // Be lenient if an absolute path was given
            if (resourcePath.startsWith("/")) {
                resource = classLoader.getResource(resourcePath.replaceFirst("/", ""));
                if (resource != null) {
                    return resource;
                }
            }
        }

        throw new IllegalArgumentException("Resource with path " + resourcePath + " could not be found on any of these classloaders: " + classLoadersToSearch);
    }
}
