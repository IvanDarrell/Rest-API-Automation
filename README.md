This automation is built using selenium java / TestNG. It uses the restAssured library for running the methods inside test classes. This is a framework that can also work in other API's.

🚀 Features

CRUD Functionality
Logs Request
POJO 

📦 Installation
Download the file
Run the testNG.xml in the automation project

📓Notes
When Running the Automation kindly change the value of the variable in RequestSpec class. It contains Base URL, Public Token and the API Token.

The automation run depends on RecordPostTest method which contains the @TestNG Group (createRecord). If you to run the specific Test class just edit the recordId variable in TestData class!
