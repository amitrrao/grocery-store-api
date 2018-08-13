# grocery-store-app

### Description
This is a simple Grocery Store application. It is implemented as a REST based Java web service that takes the location of a JSON file as a command-line parameter to initialize the database. The application populates an embedded Apache Derby database with data from the input file. It uses Spring boot under the covers with Apache Tomcat as its web server. The API design follows a Builder pattern to build an object of the DTO (GroceryItem).

 * A sample input file has been included and can be found here: com/exercise/webapp/data/input.json
 
 * The default Tomcat port for this application is 4020. If this needs to be changed, the configuration can be updated in src/main/resources/
application.properties.

 * The application logs can be found here: logs/exercise.log.

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

* Step 4. Click on individual REST methods for more details about it.

* Step 5. For each REST call, there is a 'Try it out!' option to test that particular method.

* Step 6. Verify that the ~/logs/exercise.log file has relevant log messages.

### Future work:
 * Integration tests - this is for testing queries that work on the database to fetch data.
 * Add a REST API to load the database if it has not bean initialized during start up.