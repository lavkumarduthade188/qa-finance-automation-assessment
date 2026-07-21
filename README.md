# QA Automation Assessment — Finance Application Workflows

This repository contains the manual test design, UI page object automation, and API test framework completed for the QA Engineer take-home assessment.

---

## Project Overview

### 1. Application Chosen & Justification
* **Application:** OrangeHRM (UI Testing) & ReqRes (API Testing)
* **Why:** OrangeHRM was selected to validate fundamental business workflows like authentication and form validation across complex production-like UI elements. ReqRes was selected to demonstrate a modern, decoupled backend testing strategy utilizing robust RESTful API endpoints.

### 2. Framework & Languages Used
* **Language:** Java
* **UI Automation:** Selenium WebDriver utilizing the Page Object Model (POM) design pattern for clean, maintainable separation of UI elements and test scripts.
* **API Testing:** REST Assured for fluent validation of HTTP requests, payload structures, and backend responses.
* **Build Tool & Runner:** Maven alongside TestNG for structured execution and comprehensive test reporting.

### 3. Setup & How to Run the Tests
Ensure you have Java JDK 11+ and Maven installed on your machine.

* **Running UI Tests:**
  * **Via Terminal:** 
    1. Navigate to the UI directory: `cd ui-tests`
    2. Run the suite: `mvn clean test`
  * **Via IDE:** Navigate to the `tests` folder, open the target test file, right-click inside the file, and select **Run as TestNG**.
  
* **Running API Tests:**
  * **Via Terminal:** 
    1. Navigate to the API directory: `cd api-tests`
    2. Run the suite: `mvn clean test`
  * **Via IDE:** Locate the `testng.xml` configuration file, right-click on it, and select **Run as TestNG**.

### 4. Assumptions & Limitations
* **Assumptions:** Public test servers (OrangeHRM and ReqRes) are online, and local API tokens are configured before running.
* **Limitations:** Multi-factor authentication (MFA) and CAPTCHAs are excluded from automation and verified manually.

---

## Repository Directory Structure

```text
.
├── test-cases/
│   ├── manual-test-cases.md
│   └── Manual_Test_Cases.xlsx
├── ui-tests/
│   └── src/
│       ├── main/java/pages/
│       └── src/test/java/tests/
└── api-tests/
    └── src/
        ├── test/resources/
        └── test/java/tests/
