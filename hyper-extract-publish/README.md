### Steps to install the Talend Hyper Extract Publish Component

checkout the project from git.
```sh 
git clone https://github.com/dmanojbabu/talend-components
```

Change the current directory to virtusa-talend-component.
```sh
cd talend-components/hyper-extract-publish
```

install the tableau dependencies in local maven repository.
```sh
mvn install:install-file -Dfile=lib/jna-5.2.0.jar -DgroupId=com.sun.jna -DartifactId=jna -Dversion=5.2.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi -Dversion=6.0.0.10309 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi-windows.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi-windows -Dversion=6.0.0.10309 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi-linux.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi-linux -Dversion=6.0.0.10309 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi-macos.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi-macos -Dversion=6.0.0.10309 -Dpackaging=jar
```

Load the project in IntelliJ IDEA and build the component with the below command.
```sh
gradlew clean build
```
For OS Specific build add paramenter windows or linux or macos  
Example for linux:  
```sh
gradlew clean build -Pbuildos=linux
```


Deploy the component to the studio with the below command providing the studio home path and ensure Talend studio is closed before deploy.
```sh
java -jar build/libs/hyper-extract-publish.car studio-deploy "TALEND_STUDIO_HOME"
```
