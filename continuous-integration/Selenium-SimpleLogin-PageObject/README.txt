Selenium WebDriver Tests
-------------------------------------------------------------------------------
http://www.automationtestinghub.com/selenium-3/

In order to run the implemented Selenium test cases execute the following tasks:

1. Start Web application
------------------------
For testing purposes, we use a simple Web application called "Servlet-SimpleLogin"
which can be found in the web-applications folder.

$ cd web-applications/Servlet-SimpleLogin
$ mvn wildfly:run

We can test the running Web application with a browser:
URL: http://localhost:8080/Servlet-SimpleLogin/


2. Run tests using the installed Chrome browser
-----------------------------------------------
Just execute the "ChromeTest" class.


3. Run tests using the installed Firefox browser
------------------------------------------------
Make sure that the geckodriver is in installed.
https://github.com/mozilla/geckodriver/releases

Example:
    home/student/install/geckodriver/geckodriver

Execute the "FirefoxTest" class.