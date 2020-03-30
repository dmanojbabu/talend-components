### Steps to install the Talend Tableau Hyper Output Component

checkout the project from git.
```sh 
git clone https://github.com/dmanojbabu/virtusa-talend-component
```

Change the current directory to virtusa-talend-component.
```sh
cd virtusa-talend-component
```

install the tableau dependencies in local maven repository.
```sh
mvn install:install-file -Dfile=lib/jna-5.2.0.jar -DgroupId=com.sun.jna -DartifactId=jna -Dversion=5.2.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi -Dversion=1.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi-windows.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi-windows -Dversion=1.0 -Dpackaging=jar
```

Load the project in IntelliJ IDEA and build the component with the below command.
```sh
gradlew clean build
```

Deploy the component to the studio with the below command providing the studio home path and ensure Talend studio is closed before deploy.
```sh
java -jar build/libs/virtusa-talend-component.car studio-deploy "TALEND_STUDIO_HOME"
```
