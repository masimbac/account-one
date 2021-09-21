# account-one
A project to POC management of accounts

## Instructions

Fork, then download or clone the repo.
```bash
git clone https://github.com/<your-user-name>/account-one.git
```

Change the directory.
```bash
cd into the project directory.
```

Ensure that you have at least Java 8 and Maven installed on your machine and run the below.
```bash
mvn clean install
```

Run the java app using the below command.
```bash
java -jar account-one-api/target/account-one-api-0.0.1-SNAPSHOT.jar
```

To view the Swagger docs navigate to the below in your browser.
```bash
http://localhost:8080/swagger-ui.html
```

##CI/CD
This project uses Git Actions to build and run tests when a push / change resuest is issued on the main and dev branches.
Upon release, the project will build, test, create a docker image that is published to the AWS ECR.