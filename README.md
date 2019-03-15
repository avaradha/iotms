IoT Microservices (iotms) is a Spring Boot based microservices template that include the following frameworks.

 - Bootstrap and CoreUI
 - Prometheus Metrics Monitoring
 - Lifecycle Management
 - Central Configuration
 - JSON Web Tokens (JWT)
 - Hazelcast Clustering
 - Swagger API Documentation
  
### Build
To start development using this template, clone the repo and use the continous build to detect changes when editing the project in an IDE like Eclipse or Visual Studio Code. Open the first command window and enter the following commands.

```console
$ cd ~/workspace
$ git clone git@github.com:openecs/iotms.git <my-project-name>
$ cd <my-project-name>
$ ./gradlew build -t
```

On the second command window, enter this command to run the service.

```console
$ cd ~/workspace/<my-project-name>
$ ./gradlew bootRun
````

Once the program started, open the URL with a browser.

> http://localhost:8090/