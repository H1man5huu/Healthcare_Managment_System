ONLINE HEALTHCARE MANAGEMENT SYSTEM
==================================

A Java Swing based Healthcare Management System integrated with MySQL using JDBC.
The project demonstrates core Java concepts including OOP principles, multithreading,
exception handling, DAO pattern, and basic servlet implementation.

This project is developed for academic evaluation and portfolio purposes and is
released under the MIT License.

-----------------------------------------------------------------------

ABOUT THE PROJECT
-----------------
The Online Healthcare Management System provides a complete hospital workflow
management solution. It enables hospital staff to manage patients, laboratory
requests, radiology imaging, and telemedicine consultations through a desktop GUI.

The system is designed with clean separation of concerns using:
- Swing GUI layer
- DAO (Database Access Object) layer
- Utility classes for database connectivity

This project is suitable for:
- GUVI Java GUI Based Project submission
- Academic learning of Java + JDBC
- Demonstrating OOP, Threads, and Servlets
- Beginner to intermediate Java portfolios

-----------------------------------------------------------------------

FEATURES IMPLEMENTED
--------------------

1. Patient Management
- Add new patients
- View all patient information
- Update patient details
- Discharge patients

2. Laboratory Module
- Doctors can place lab test requests
- Lab technicians can update test results
- Reports are generated and linked to patients
- Uses inheritance, polymorphism, and custom exceptions

3. Radiology Module
- Imaging requests such as X-Ray / MRI
- Radiology technicians can enter findings
- Reports automatically associated with patients

4. Telemedicine Module
- Simulated doctor-patient virtual consultation
- Implemented using multithreading
- Each consultation runs in a separate synchronized thread
- Demonstrates innovation and extra effort

5. Database Integration
- MySQL database connectivity using JDBC
- DAO classes handle all SQL operations
- PreparedStatement used for security and performance

6. Servlet Integration
- Basic servlet implemented using HttpServlet
- web.xml deployment descriptor included
- Demonstrates backend web handling concept

-----------------------------------------------------------------------

TECHNOLOGIES USED
-----------------
- Java (JDK 8 or above)
- Java Swing (GUI)
- MySQL Database
- JDBC (Java Database Connectivity)
- Apache Tomcat (Servlet execution)
- DAO Design Pattern
- Multithreading
- Custom Exception Handling

-----------------------------------------------------------------------

PROJECT STRUCTURE
-----------------
Healthcare_Managment_System
|
|-- src/
|   |-- hospital/management/system/
|       |-- dao/
|       |-- lab/
|       |-- radiology/
|       |-- telemedicine/
|       |-- servlet/
|       |-- exception/
|       |-- util/
|       |-- Reception.java
|
|-- WEB-INF/
|   |-- web.xml
|
|-- sql/
|   |-- hospital.sql
|
|-- icon/
|
|-- README.md

-----------------------------------------------------------------------

DATABASE SETUP
--------------
1. Start MySQL Server
2. Open MySQL Command Line or Workbench
3. Execute the SQL script:

mysql -u root -p
SOURCE sql/hospital.sql;

Database Name:
hospital

Tables Created:
- patient
- lab_requests
- radiology_requests
- telemedicine_sessions

-----------------------------------------------------------------------

HOW TO RUN THE PROJECT (WINDOWS)
--------------------------------

METHOD 1: Using VS Code
1. Open VS Code
2. File -> Open Folder -> Select project folder
3. Open Reception.java
4. Right click -> Run Java
5. GUI window will open

METHOD 2: Using Command Prompt
1. Open Command Prompt
2. Navigate to project folder

cd path\to\Healthcare_Managment_System

3. Compile project

javac -d out src\hospital\management\system\**\*.java

4. Run application

java -cp out hospital.management.system.Reception

-----------------------------------------------------------------------

SERVLET EXECUTION
-----------------
1. Deploy project on Apache Tomcat
2. web.xml is located inside WEB-INF folder
3. Start Tomcat server
4. Access servlet using browser:

http://localhost:8080/HealthcareManagement/patient

Servlet output confirms successful deployment.

-----------------------------------------------------------------------

GUVI EVALUATION COVERAGE
------------------------
- OOP Implementation: Inheritance, Polymorphism, Interface, Exception Handling
- Collections & JDBC ResultSets
- Multithreading & Synchronization (Telemedicine)
- DAO Classes for Database Operations
- JDBC Connectivity
- Servlet Implementation
- Innovation through Telemedicine Module

-----------------------------------------------------------------------

LICENSE
-------
MIT License

Copyright (c) 2024

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software.

The project is open for educational and personal use.
Attribution is optional but appreciated.

-----------------------------------------------------------------------


