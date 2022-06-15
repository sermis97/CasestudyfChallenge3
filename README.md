Challenge 1: The Song of Ice and Water (and Steam)

First of all, we need to understand the structure of API and its requirements for testing it. For this, we need to check if there is a Swagger file showing required parameter and default responses for each end point. If this is not available, we can find this info from previous backlog items related to creation of these end points, or we directly ask to developers for acceptance criteria. 

Testing:
Testing Authorization:
Most likely there must be a authorization process to reach these endpoints. If the authorization method used is Bearer token, then we must add cases for positive and negative scenarios (correct credentials for positive and wrong credentials for negative testing).
If there is anything wrong with the credential we send, then we should get 401 error code.

Testing Endpoints: 
In this example, these endpoint might return the values defined in the payload in two ways:
This payload value might be a path param, for example, the endpoint might be like:
www.example.com/api/10

This end point might be developed to bring only “ice” as response. Similarly, 
www.example.com/api/20 might bring “water”.

If the endpoints are working as expected, then we should receive pre-defined response body, with the status code 200. If server is down, we might get 500 error code.
In either case, to be sure that the response is coming in the desired form, we need to have a test case for schema validation.

These values might be query params. In that case, among the values that might come as a response from an endpoint, we are filtering the results based on the payload valued we are sending. Let’s say there are 100 records in the database at the backend which would come from that end point if we do not send any query para, but since we are only interested in send a value to bring ‘water’, then we send that value as payload param to filter the response. 

In this case, we need to test these scenarios:
Happy Paths Positive Testing: By using Boundary Value Analysis and Equivalence Partitioning Testing, we need to check all possible values that might bring ‘water’ as a response. For example, the developer might have said that the numbers between 1-1000 will bring ‘water’. 
So, we need to write test cases which will check boundaries (upper and lower limits, which are 1 and 1000 in this case) to see if it is bringing the correct response. Since it is not feasible to write 1000 test case, we can pick random data values by using equivalent class partitions and create tests for these sample. For example, we can divide the data as 1 to 100, 101 to 200, 201 to 300 and so on.  Then we can pick 111, 234, 333 as random values to test. If these values work, then we assume the others will work as well.
In this happy path, we should receive 200 as HTTP response code.

As a negative testing, we need to check one above and below of boundary values (-1 and 1001). These values should not bring ‘water’, but it must bring the response which is supposed to return as a response in these cases (these are all set by developers during API creation). It might be something “Payload value is wrong”. Or these responses might be more than once. For example, when payload value is sent as -1, a negative number, then response might be ‘payload value cannot be negative’. Similarly, if above 1000, it might be ‘payload value cannot exceed 1000’.
In these cases, we should receive 400 as HTTP response code.

As another negative test, we need to check sending string and symbols as payload values, then observe the responses. 
In these cases, we should receive 400 as HTTP response code.
For every response, we need to have schema validation test as well.

Non-Functional tests:
An acceptable response time for any end point used in the company should be defined by business analysts and product owners. Normally, it should be below 1000 milliseconds for an endpoint to be at acceptable speed (it may change based on the company). By using JMeter performance testing tool, it should be measured and reported if the endpoints are not meeting this criterion. 

A stress or Load test might be executed to test how the endpoints are behaving under for example 1000 concurrent request at the same time.

APIs bring the results from the database directly, but they do not check if the data received is correct. The calculation behind it (at database SQL level) might be wrong. For example, if we are looking for all male students having green eyes in a school students list, then API might bring us a 50, but in fact it might be 60.
API might be working properly but the calculation behind it might be wrong. 
Developers must add required unit tests for it, but to be on the safe side, we can create a small database by MS Entity Framework and direct our endpoints to retrieve data from there. Since the data set will be small, we might expect what results to come, then we can compare it with the results we are receiving from APIs. 
If we want all these things to happen in a closed environment to eliminate any environmental effects, we can use Docker to execute our cases.

4.	How would you approach the automation?

For manual testing of APIs, I would use Postman. 
For automation, I would highly suggest Postman Automation.
If we need a code based approach, then based on the programming language preferred by the company, I would use Java+ RestAssured+ Cucumber (JDBC if database testing needed)  or C#+ RestSharp + SpecFlow (Entity Framework if database testing needed).

5.	What challenges in CI?

The automation framework we will create might have some dependency to run. For example, if it is dependent on the successful build of any branch, in case of any fails in building the code, test cases in automation suite will not run. So, we should be careful about the dependencies.

Similarly, if any release is dependent on successful execution of the automation suite, then it will and not release fail if the suite fails. So, we must configure build and release settings and dependencies carefully.

Test cases in the framework will run on an agent in the pipeline (Either in Azure, AWS or TeamCity etc). These agents are virtual machines. If the capacity of these VMs are low (let’s say we have i7 and 64 Mb RAM in our local PC, but the agent has i5 and 8 Mb Ram), then the execution might be slower, so wait times might be longer when compared to our local PCs.. Conversely, our pc might be slower than the agent. These kind of performance issues affect wait times for sending and receiving responses. These issues should be monitored carefully, and tests need to be revised accordingly.

There might be problems due to VCS from where the CI is getting the code. The server (for example Git or TFS) might be down, so code cannot be pulled and compiled. In this case, tests will not run.

Similarly, servers hosting API endpoints might be down, so the test will fail on the CI directly.

If we use Postman Automation, Newman is used for CI test runs for it. There might be some problems between these two related to variable scopes used in the test case. For example, environment variables used in Postman itself cannot be recognized by Newman. They must be stored as global variables.

#################################################################################

Challenge 2: The Song of Airtame
The product uses video and graphics intensively. Image based testing or graphical testing is doable but a very challenging area in testing. There are available libraries to test these kinds of products. I will investigate and use these libraries.

The product uses physical devices and a cloud platform. End-2-End testing to cover all user activities might be challenging. 

##################################################################################

Challenge 3: Buy in

# CasestudyfChallenge3
This task is about adding products to the cart and verifying the total price of Airtame products.This

Framework used in this project is Cucumber BDD framework based on POM

There is a BasePage class which contains the locator for the elements

Inside runners folder there is runners class named CukesRunner

We can run our test by right click on this file or we can use maven lifecycle to run the test.

Under resources there is a features folder which I keep the feature file(scenario) which is written in Gherkin.This


Step_definitions folder contains actual test script.

Under utilities, there is a class named Driver which has been created with Singleton which makes me to use only one driver instance at once.

and also a class name Conf. Reader that makes possible to read related configuration from properties file under resources

and finall there is a class named BrowserUtils where I keep useful functions which can be used anywhere I need throughout the project



