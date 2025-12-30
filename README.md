# M004-JAVA-SELENIUM-TESTNG-BDD

Java Selenium test automation project (Demo). Uses Maven, TestNG and BDD-style feature files.

## Tech stack
- Java (JDK 11+)
- Maven
- Selenium WebDriver
- TestNG
- Cucumber-style feature files (BDD)
- IntelliJ IDEA (tested on Windows)

## Project structure (important files)
- `pom.xml` - Maven configuration and dependencies
- `src/main/java/pages/ElementsPage.java`
- `src/main/java/pages/HomePage.java`
- `src/main/java/utils/DriverFactory.java`
- `src/test/java/features/HomePage.feature`
- `src/test/java/runners/TestRunner.java`
- `src/test/java/stepdefinitions/HomePageSteps.java`

## Prerequisites
- JDK 11 or newer installed and `JAVA_HOME` set
- Maven installed and on `PATH`
- A browser driver (ChromeDriver/EdgeDriver) or use WebDriverManager if enabled
- IntelliJ IDEA (Windows, configured for Maven projects)

## Setup
1. Clone the repository:
    - `git clone <repo-url>`
2. From project root run:
    - `mvn clean install`

## Running tests
- Run all tests with Maven:
    - `mvn clean test`
- Run tests from IntelliJ:
    - Open the project and run `src/test/java/runners/TestRunner.java`
- To run a specific TestNG/Cucumber profile, adjust `TestRunner` or pass system properties as implemented (for example `-Dbrowser=chrome` if supported by `DriverFactory`).

## Driver configuration
- Edit `src/main/java/utils/DriverFactory.java` to change default browser or driver path.
- Alternatively, the project may accept a system property (e.g. `-Dbrowser=chrome`) — check `DriverFactory` and pass it to Maven:
    - `mvn test -Dbrowser=firefox`

## Reports and artifacts
- Test output and compiled classes: `target/`
- Check `target/surefire-reports` or project-specific report folders after test run.

## Best practices used
- Page Object Model (`pages` package)
- Centralized WebDriver setup (`utils/DriverFactory.java`)
- Explicit waits in page classes (e.g. `ElementsPage`)
- BDD feature files separated from step definitions

## Contributing
- Follow project conventions (POM, package layout)
- Add feature scenarios in `src/test/java/features`
- Add step definitions in `src/test/java/stepdefinitions`

## License
- MIT (or add your preferred license)
