# GhDemo Service

## Architectural Decision Records
### Authentication
Since the service is not meant to be visible to the outside world and 
I will not provide my GitHub API token, there is no need for complicating a simple 
recruitment task service with authentication, hence it is not going to be implemented.


## Setup

### Database
The database required for the project is PostgreSQL. The connection properties 
are passed in `application.properties`. You need to create this file manually by copying 
`application.template.properties` into `application.properties`. 
Make sure to fill the values.

### Installation

Build the project using `mvn install`

## Running

### Tests

Run the tests using `mvn test`

### Application

Run the application using `java -jar target/gh-demo-0.0.1-SNAPSHOT.jar`
