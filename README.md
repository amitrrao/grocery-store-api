# grocery-store-app

### Description
This is an exercise to implement a simple Grocery Store application. This is implemented as a simple REST based Java web service that requires the location of an input file (.json format) as a commandline parameter. This application populates an embedded Apache Derby database with test data coming from the input.json file in the com.exercise.webapp.data package. It uses [Spring boot](https://projects.spring.io/spring-boot/) under the covers with Apache Tomcat as its webserver. The default Tomcat port for this application is 4020. If this needs to be changed, you can modify application.properties file under the src/main/resources/ folder.

The API design follows a Builder pattern to build a Json specific GroceryItem object that can be sent back as an HTTP response object.

The application logs can be found at logs/exercise.log.

### System Requirements:
 * [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 * [Maven](https://maven.apache.org/download.cgi#)

### Instructions to Build and Run:
* Step 1. Unzip the grocery-store.zip file

* Step 2. `cd` to the `grocery-store` folder

* Step 3. Run the following Maven command to build the jar:
 `mvn clean package`
 
 * Step 4. Run the application using the following command:
 `java -jar target/grocery-store-1.0.0.jar <location_of_the_input.json_file>`
 E.g: `java -jar target/grocery-store-1.0.0.jar ./src/main/java/com/exercise/webapp/data/input.json`
 
 The application is now running.

### Instructions to for testing various REST calls:

This application comes with a Swagger UI for testing all the implemented REST methods. In order to test, follow these steps:

* Step 1. Start the application.

* Step 2. Open a browser and navigate to http://localhost:4020/swagger-ui.html (You may have to change the port if it's not defaulted to 4020).

* Step 3. Click on the 'grocery-item-controller' to see the list of all supported REST calls.

* Step 4. Click on individual calls for more details about it.

* Step 5. For each REST call, there is a 'Try it out!' option to test that particular method.

* Step 6. Verify that the ~/logs/exercise.log file has relevant messages.
