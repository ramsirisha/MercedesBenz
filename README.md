Instructions to run Mercedes Benz Automation script:
Please follow below instructions before executing Mercedes Benz automation script
•	Download the script from provided GIT Repository
•	Automation script implementation details-
			Programming Language: Java 
			Testing Tool: Selenium WebDriver
			Framework: TestNG framework using Page Object Model
			Build Tool: Maven Dependencies
			Report: Extent Report
			Logging: Log4j2
•	Update the browser value to chrome/edge in “data.properties” file- 
		o	Path: \src\main\java\org.mercedes\resources\data.properties
•	Run “testing.xml” file to execute the automation script – Path:\Selenium\IdeaProjects\MercedesBenz
•	Refer to test data excel file to update details such as Body Type, First Name, Last Name etc - Path :\src\main\java\org.mercedes\resources\testdata\data.xlsx
•	Refer to "benzTest.java" for test script - Path: \src\test\java\org.benz\testscripts
•	Path to refer to Page classes - Path: \src\main\java\org.mercedes\pages
•	Path to refer to Extent Report - Path: \reports\ExtentReport.html
•	Path to refer to Log file - Path: \logs\logFile.log
•	Path to refer to failure screenshots - Path: \reports\Screenshots

Following is the flow implemented in provided automation script:
•	Launches Mercedes Benz URL based on browser details provided in data.properties file.
•	Handles Messenger icon and accepts cookies.
•	Selects Body Type based on value provided for “BodyType” in data.xlsx file.
•	Selects one Vehicle from the list and navigates to product’s details page.
•	Clicks on Contact Me button.
•	Verifies if “Contacts details” popup is displayed and fills in required details in it.
•	Verifies if “Proceed” button is enabled.
