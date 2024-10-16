# Parking_Garage_Automation_Group_Project
## Introduction
This project is part of the CSCI_441 Software Engineering course, developed by Team B. 
Team B consists of Nicole Brandenburg (Team Lead), Oakley Cardwell, and Gene Holt. 
The repository includes the initial stages of a Java-based application for optimizing parking garage operations. 
Future possible implementations are outlined in the included report.

## Getting Started
### Prerequisites
Java JDK 1.8 or higher  
Maven 3.6.3 or higher

## Running the Application
### Clone the Repository
git clone https://github.com/nbrandenburg/Parking_Garage_Automation_Group_Project.git  
cd Parking_Garage_Automation_Group_Project 

### Run the Main Application
The main application file is Application.java located in src/main/java/com/ParkingGarageOptimizer/.
To run the application, execute the following command:  
  
mvn spring-boot:run

### Access the Application
Once the application is running, you can access it at localhost:8080. The default login for user functions is:

username: user    
password: password

### Access the Admin Panel
The application has an admin panel to run executive functions on the system. It can be accessed at localhost:8080/adminlogin. The default login for admin functions is:

username: admin    
password: password

## Running the Tests
### Test Classes

The test classes are located in src/test/java/com/ParkingGarageOptimizer/.
This includes tests for various components like AuthenticationTest, DataLoaderTest, ParkingTransactionTest, etc.

### Run Tests Using Maven

To run the test classes, use the following Maven command:  
  
mvn test  

## Additional Information
For more details on the project structure and components, refer to the documents in the documents directory.
The application properties can be configured in src/main/resources/application.properties.

