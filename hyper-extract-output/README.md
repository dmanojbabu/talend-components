### Steps to install the Talend Tableau Hyper Output Component
---

checkout the project from git.
```sh 
git clone https://github.com/dmanojbabu/talend-components
```

Change the current directory to talend-components/hyper-extract-output.
```sh
cd talend-components/hyper-extract-output
```

install the tableau dependencies in local maven repository.
```sh
mvn install:install-file -Dfile=lib/jna-5.2.0.jar -DgroupId=com.sun.jna -DartifactId=jna -Dversion=5.2.0 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi -Dversion=6.0.0.10309 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi-windows.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi-windows -Dversion=6.0.0.10309 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi-linux.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi-linux -Dversion=6.0.0.10309 -Dpackaging=jar
mvn install:install-file -Dfile=lib/tableauhyperapi-macos.jar -DgroupId=com.tableau -DartifactId=tableauhyperapi-macos -Dversion=6.0.0.10309 -Dpackaging=jar
```

### Download Hyper API Dependencies - Includes Hyper API Jar and binary files   
[Hyper API Windows](https://downloads.tableau.com/tssoftware/tableauhyperapi-java-windows-x86_64-release-hyperapi_release_6.0.0.10309.rf8b2e5f7.zip)   
[Hyper API Linux](https://downloads.tableau.com/tssoftware/tableauhyperapi-java-linux-x86_64-release-hyperapi_release_6.0.0.10309.rf8b2e5f7.zip)   
[Hyper API Macos](https://downloads.tableau.com/tssoftware/tableauhyperapi-java-macos-x86_64-release-hyperapi_release_6.0.0.10309.rf8b2e5f7.zip)   

Copy the binary executable from the downloaded files and place in src\main\resources folder as below

- For Windows:       
    - copy hyperd.exe, hyperdstarter.exe, crashdumper.exe into below structure   
      - src/main/resources/tableau/hyper-windows/
- For Linux:  
    - copy hyperd, hyperdstarter into below  
      - structure src/main/resources/tableau/hyper-linux/
- For Macos:  
    - copy hyperd, hyperdstarter into below structure  
      - src/main/resources/tableau/hyper-macos/


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
java -jar build/libs/hyper-extract-output.car studio-deploy "TALEND_STUDIO_HOME"
```
