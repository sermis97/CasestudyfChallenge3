# CasestudyfChallenge3
This task is about adding products to the cart and
verifying the total price of Airtame products.This

Framework used in this project is Cucumber BDD framework based on POM
There is a BasePage class which contains the locator for the elements

Inside runners folder there is runners class named CukesRunner
We can run our test by right click on this file or we can use maven lifecycle to run the test.

Under resources there is a features folder which I keep the feature file(scenario) which is written in Gherkin.This


Step_definitions folder contains actual test script.

Under utilities, there is a class named Driver which has been created with Singleton which makes me to use only one driver instance at once.
and also a class name Conf. Reader that makes possible to read related configuration from properties file under resources
and finall there is a class named BrowserUtils where I keep useful functions which can be used anywhere I need throughout the project
