# Selenium Automation Framework

## Overview

The Selenium Automation Framework is a robust and scalable automation framework designed to simplify web application testing using Selenium WebDriver. It provides a structured and organized approach to create and maintain automated test scripts, making it easier for testers to write and execute tests.

## Features

- **Modular Design:** The framework follows a modular design, allowing testers to easily manage and extend test cases.
- **Page Object Model (POM):** Implements the Page Object Model design pattern for better code maintenance and reusability.
- **Configuration Management:** Centralized configuration management for easy maintenance of test environment details.
- **Test Data Management:** Supports various methods for managing test data, ensuring flexibility in test execution.
- **Logging and Reporting:** Integrated logging and reporting features for detailed test execution reports.

## Getting Started

### Prerequisites

- [Java](https://www.java.com/) installed
- [Maven](https://maven.apache.org/) installed
- ### Note : Browser-specific WebDriver executable is not required, Selenium Manager will take care of this.

### Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/MaheshDeevi/SeleniumAutomationFramework.git
    ```

2. Navigate to the project directory:

    ```bash
    cd SeleniumAutomationFramework
    ```

3. Install dependencies:

    ```bash
    mvn clean install
    ```

### Usage

1. Configure test parameters in `config.properties`.
2. Write test scripts in the `src/test/java` directory.
3. Run tests using the following command:

    ```bash
    mvn test
    ```

## Contributing

Contributions are welcome! Please follow the [contribution guidelines](CONTRIBUTING.md).

## Acknowledgments

- [SeleniumHQ](https://www.selenium.dev/) for providing the Selenium WebDriver.
- [Maven](https://maven.apache.org/) for project management and build automation.


