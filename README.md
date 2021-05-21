# Alas d.o.o. Java developer test assignment

## How to run the application

1. Install Java 11: Go to https://adoptopenjdk.net/ and download version 11. If the Operating System is Windows: set the
   system environments for `JAVA_HOME` (jdk root folder) and `PATH` (jdk root folder\bin)
2. To start the backend run `mvn spring-boot:run` command (control + c will kill the application)
3. Build the frontend: `cd src/frontend`, `yarn`. (install `yarn` and `node` if needed)
4. To start the frontend go to `src/frontend` and run `yarn start`. It will run on `localhost:3000`.
5. To run tests:
    - Using Mozilla Firefox: `mvn test -DbrowserFamily=firefox`
    - Using Google Chrome: `mvn test -DbrowserFamily=chrome`
    - Using Opera: `mvn test -DbrowserFamily=opera`
    - Using Microsoft Edge: `mvn test -DbrowserFamily=edge`
