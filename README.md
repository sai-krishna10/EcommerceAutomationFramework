**🛒 E-Commerce Automation Testing Framework**
**📌 Project Overview**

This project is a scalable Hybrid Automation Framework developed using Java, Selenium WebDriver, and TestNG to automate an E-Commerce web application.
It follows industry-standard design principles such as Page Object Model (POM), Data-Driven, and Keyword-Driven approaches, with seamless integration of Extent Reports, Git, and CI/CD (Jenkins).

The framework is designed to support parallel execution, cross-browser testing, and easy maintenance, making it suitable for real-time enterprise projects.

**🧰 Tech Stack**

Programming Language: Java

Automation Tool: Selenium WebDriver

Test Framework: TestNG

Build Tool: Maven

Design Pattern: Page Object Model (POM)

Reporting: Extent Reports

Data Source: Excel (Apache POI)

Version Control: Git & GitHub


🏗 Framework Architecture
├── src/main/java
│   ├── base
│   │   ├── BaseTest.java
│   │   └── BasePage.java
│   ├── pages
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── RegistrationPage.java
│   │   └── SearchPage.java
│   ├── utils
│   │   ├── CommonUtils.java
│   │   ├── ExcelUtils.java
│   │   ├── ExtentListener.java
│   │   └── ConfigReader.java
│
├── src/test/java
│   ├── tests
│   │   ├── login
│   │   ├── register
│   │   ├── search
│   │   └── cart
│
├── src/test/resources
│   ├── config
│   │   └── Config.properties
│   ├── testdata
│   │   └── TestData.xlsx
│   ├── screenshots
│
├── testng.xml
├── pom.xml
└── README.md

**🔑 Framework Features**

✔ Hybrid Framework (POM + Data-Driven + Keyword-Driven)
✔ Parallel execution using TestNG
✔ Cross-browser support (Chrome, Firefox, Edge)
✔ Extent HTML reports with screenshots
✔ Centralized configuration management
✔ Screenshot capture on failure
✔ Maven build support
✔ Jenkins CI integration
✔ Scalable and maintainable architecture

**🧪 Automated Test Scenarios**
✅ Registration

Mandatory fields validation

All fields validation

Negative scenarios

✅ Login

Valid credentials

Invalid credentials

Empty credentials

✅ Search

Valid product search

Invalid product search

Empty search

✅ Cart

Add single product

Add multiple products

Cart count validation

✅ Logout

Successful logout validation

📊 Reporting

Extent Reports are generated automatically after execution

Includes:

Test steps

Pass/Fail status

Failure screenshots

Execution time


**🧠 Key Learnings**

Real-time automation framework design

Selenium best practices

TestNG listeners & parallel execution

Robust reporting mechanism

Enterprise-level project structure

👤 Author

Pabbu Sai Krishna
QA Automation Engineer | Java | Selenium | TestNG | Hybrid Framework
