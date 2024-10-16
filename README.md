nopCommerce Website Automation Testing

• This project contains automated tests for the login, registration, search, wishlist and Cart pages of a demo NopCommerce website. • The tests are implemented using the Page Object Model (POM) design pattern, • Selenium WebDriver, and Java.
Getting Started

To get started with this project, follow the instructions below.
Prerequisites

    Java JDK installed
    Maven build tool installed
    Chrome or Firefox browser installed

Clone the Repository

Clone this repository to your local machine using the following command: git clone https://github.com/samarelshamey/demo-nopcommerce.git
Configuration

    Open the project in your preferred IDE.
    Update the config.properties file located in the src/test/resources directory with the necessary configuration details such as the website URL, login credentials, etc.

Test Structure

The tests are organized using the Page Object Model (POM) design pattern, which separates the test logic from the page-specific operations.

The test classes are located in the src/test/java/com.nopcommerce/testCase directory: • The test classes are as follows:

    T01_Register: Contains tests for the registration functionality.
    T02_Login: Contains tests for the login functionality.
    T03_Search: Contains tests for the search functionality.
    T04_Wishlist: Contains tests for the Wishlist functionality.
    T05_Cart: Contains tests for the cart functionality. Each test class contains multiple test methods, each representing a specific test scenario. The test methods interact with the respective page classes to perform actions and assertions.
