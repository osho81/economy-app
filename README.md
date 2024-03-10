# EconomyApp-Backend
- Diving deep into Spring Boot and Java. 
- Building a REST API for learning purposes

## Build (maven) app
- cd to root folder in terminal
- run command: 
  - mvn clean install

## Run locally via command line
- cd to root folder in terminal
- run command:
  - mvn spring-boot:run

## Run locally via run configurations (IDE play button)
- (This springboot-config example uses intellij)
- Edit run configurations
  - If Intellij has not recognized this springboot app (after maven build)
      - select JDK
      - set main class: EconomyAppBackendApplication
      - 