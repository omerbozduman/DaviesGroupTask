Davies-Group Web Page Testing Exercise / Instructions
Codes and Tests Prepared by:
Faruk Ugur

Software Development in Test 

farukugur86@gmail.com

https://www.linkedin.com/in/..../

- Build Tool: Maven 
- Dependencies : Selenium-Java ,Bonigarcia-WebDriverManager, Cucumber J-Unit, Cucumber Java

- Test Framework: Cucumber BBD (with JUnit Assertions) based on Page Object Model(POM)

WebPage URL :
https://davies-group.com/


QA Task:
1)	Open the following Web app from https://davies-group.com/
2) 	Identify means to run automated tests on it using the below scenarios:- 
      A)  Click on ‘Twitter’ and ‘linkedIn’ Icon’s on the home page and Validate if it navigates to respective social media webpages. 
      B1) Click on ‘Solutions’ – Scroll down and click on ‘View All’  – look for ‘Fire investigation’ Case study and click on it – Validate if it’s navigated to right page. 
      B2) Capture the Results section from ‘Fire Investigation’ case study. 
      C) Click on Menu ->  ‘About Us’ -> ‘Locations’ and capture Stoke Office address from the Maps.


Acceptance Criteria:
● Validate company homepage
● Validate that user social media links are working as expected
● Validate that "Fire investigation" case study provides Results
● Validate that under About>Locations have Stoke Office Address

System Requirements:
Java 8+ SDK
Test RUN by using JUnit

Notes: To run all Scenarios, use @daviesgroup , to run the related with "social media links" scenario
use @homepage, to run the related with "Solutions" module scenario use @solutions and 
to run the related with "About" module scenario use @about tag in the CukesRunner class/Cucumber Options

Cucumber Test Feature Scenarios:

1 - HomePage - Social Media Links Scenario
a- I open the DaviesGroup webpage
b- I click the social media links
c- I should be navigate to respective social media webpages
|Twitter|
|LinkedIn|

2 - Solutions Module Scenario
a- I open the DaviesGroup webpage
b- I click the "Solutions" module
c- I scroll down and click on "View All" button
d- I search the "Fire investigation" and click on it
e- I verify that it's navigated to "Fire investigation - Davies" page
f- I capture results section on Fire investigation case study

3 - About Module > Locations SubModule Scenario
a - I open the DaviesGroup webpage
b - I click the "Locations" submodule under "About" Us module
c - I capture the "Stoke on Trent" office address
   


Note: I keep all scenario's steps in step definition because I want to show all steps.
I can keep "I open the DaviesGroup webpage" in Hooks class under @Before tag. Also I done this.
but I hide them. If you want to see how is working you can execute test scenarios through
unhide related line under @Before tag and hide the step that is in each feature under Background keyword 
