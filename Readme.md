# Spring Boot / Docker - Demo Project

Example of how a Spring Boot project might be set up to use Docker as the 
development virtualization tool.  The intention is to have enough features
to match the feel of a realistic (but small) project.  They include:

 * MySql (provided by docker)
 * MyBatis / spring-mybatis to provide persistence mapping
 * flywaydb for database migrations
 
Prerequisites

 * Java 8
 * boot2docker
 * Docker Compose

Gradle should be automatically downloaded and installed with the correct version using the Gradle wrapper.

## Sample Usage

launch development environment in docker

    $ docker-compose up -d

simple build

    $ ./gradlew build
    
clean build with docker image

    $ ./gradlew clean build buildDocker

run the application (locally)

    $ ./gradlew run

save a new task item 

    $ http -v POST localhost:8080/task description="task u"
    
get a task item

    $ http -v localhost:8080/task/1
    
update a task item

    $ http -v PUT localhost:8080/task/1 id:=1 description="updated 1" complete=true
    
