#  Kwame Newsletter Automation Testing

This project contains an automated test suite for validating the core functionalities of the [Kwame Newsletter Website](https://kwamenewsletter.vercel.app/) using **Java**, **Selenium WebDriver**, **JUnit 5**, and **GitHub Actions CI/CD**.

---

##  Table of Contents

- [About the Project](#about-the-project)
- [Technologies Used](#technologies-used)
- [Test Coverage](#test-coverage)
- [Project Structure](#project-structure)

---

##  About the Project

This automation suite tests the **Kwame Newsletter** landing page to ensure:
- Valid email signups lead to a success page.
- Invalid inputs show proper error messages.
- UI hover states behave correctly.
- The dismiss button on the success page returns the user to the homepage.

The tests use the **Page Object Model (POM)** for structure and maintainability, and are integrated into a **GitHub Actions** pipeline with Slack notifications.

---

##  Technologies Used

- **Java 21**
- **Selenium WebDriver 4.33**
- **JUnit 5.10**
- **WebDriverManager**
- **GitHub Actions**
- **Slack Webhooks**
- **Maven** for build and dependency management

---

##  Test Coverage

| Test Case ID | Description |
|--------------|-------------|
| 001         | Submit a valid email and verify success page loads |
| 002         | Click dismiss button and verify return to home page |
| 003         | Submit an invalid email and expect error message |
| 004         | Hover over subscribe button and verify style change |
| 005         | Hover over dismiss button and verify style change |

---

##  Project Structure
NewsletterTesting/
├── pom.xml
├── .github/
|    └── workflows/ kwamenewsletter.yml
|
├── src/
│ └── main/
│ └── java/com/newsletter/
│ ├── base/BasePage.java
│ └── pages/
│ ├── HomePage.java
│ └── SuccessPage.java
│
|
└── test/
└── java/com/newsletter/
└── NewsletterTest.java




