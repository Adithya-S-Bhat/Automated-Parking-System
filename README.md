# Automated-Parking-System-JavaMVC

## UE19CS353 OOAD Project

# Team Members

- [Abhishek Aditya BS](https://github.com/Abhishek-Aditya-bs), PES1UG19CS019
- [A Sai Chaithanya](https://github.com/A-Sai-Chaithanya), PES1UG19CS002
- [Adithya MS](https://github.com/Adithya-S-Bhat), PES1UG19CS027

# Problem Description

Automated Parking System allows users to park at the nearest parking location without human intervention. The application provides a default interface where a user can select if he is an admin of a parking lot or a user. If the user selects the option Parking lot admin then he is directed to a seperate interface where they can add their parking locations by specifying the parking lot name, address, latitude, longitude, total capacity and currently filled slots. If the option selected is User, then he is directed to a user registration form if he is using the application for the first time. The registration form asks users to enter their details like name, userID, password, phone number, Driver’s Licence number, Car Model, colour, plate number.

Once the user finishes the registration, he is asked to login to the system by entering the registered userID and password, and the system asks for his permission to fetch their geolocation. The geolocation is fetched by using a python API, which uses their IP address to determine the user’s latitude, longitude and its corresponding address. Once the user’s location is fetched, he is shown the top five nearest parking locations with total capacity, address and number of currently filled slots. He can choose any parking lot near him and he is shown the pricing for parking for different durations. After the user is shown the pricing, the system stores the user details with the slot number and the parking lot he has parked in, and logs out the user.

When the user comes back to the application to unpark his car, after he logs in, he is shown the details about his car and his parking slot and location. He is shown the bill for the amount of duration parked, and prompts him to choose the payment method and asks for his feedback on the user experience. After the user completes all the actions, his entry from the loggedInUsers is removed and the parking slot is freed and all other details are updated accordingly.

# Analysis and Design Models

<p align="center">
  <img width="600" height="400" src="https://github.com/Adithya-S-Bhat/Automated-Parking-System/blob/main/UML%20Diagrams/Use%20Case%20Diagram/UseCaseDiagram.jpg" />
</p>
<p align="center"> Figure 1: Use Case Diagram </p>

<p align="center">
  <img width="600" height="400" src="https://github.com/Adithya-S-Bhat/Automated-Parking-System/blob/main/UML%20Diagrams/Class%20Diagram/ClassDiagram1.jpg" />
</p>
<p align="center"> Figure 2: Class Diagram Diagram </p>

<p align="center">
  <img width="600" height="400" src="https://github.com/Adithya-S-Bhat/Automated-Parking-System/blob/main/UML%20Diagrams/State%20Diagram/StatechartDiagram.jpg" />
</p>
<p align="center"> Figure 3: State Diagram </p>

<p align="center">
  <img width="600" height="400" src="https://github.com/Adithya-S-Bhat/Automated-Parking-System/blob/main/UML%20Diagrams/Activity%20Diagram/ActivityDiagram1.jpg" />
</p>
<p align="center"> Figure 4: Activity Diagram </p>

# Tools and Frameworks Used

- Maven: Maven is a build automation tool used primarily for Java projects. Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.

- Python Geolocater: It is possible using geopy to extract the coordinates meaning its latitude and longitude. Therefore, it can be used to express the location in terms of coordinates.

- Java Swing: Java Swing tutorial is a part of Java Foundation Classes (JFC) that is used to create window-based applications. It is built on the top of AWT (Abstract Windowing Toolkit) API and entirely written in java. Unlike AWT, Java Swing provides platform-independent and lightweight components. The javax.swing package provides classes for java swing API such as JButton, JTextField, JTextArea, JRadioButton, JCheckbox, JMenu, JColorChooser etc.

- MongoDB: MongoDB is a source-available cross-platform document-oriented database program. Classified as a NoSQL database program, MongoDB uses JSON-like documents with optional schemas. MongoDB is developed by MongoDB Inc. and licensed under the Server Side Public Licence.

# Design Principles and Design Patterns Applied

1. MVC is an architectural pattern which means it rules the whole architecture of the applications. Even though often it is known as a design pattern, we may be wrong if we refer to it only as a design pattern because design patterns are used to solve a specific technical problem, whereas architecture pattern is used for solving architectural problems, so it affects the entire architecture of our application. It has three main components Model, View, Controller and each of them has specific responsibilities. Modules where MVC pattern was used in the project:
    - User Registration
    - User Login
    - Admin
    - Dashboard
    - Billing
    - WelcomeBack
    - GeoLocation

2. Keep It Simple and Stupid (KISS) Principle: The Keep it Simple and Stupid (KISS) principle is a reminder to keep your code simple and readable for humans. If your method handles multiple use-cases, split them into smaller functions. Unreadable and long methods are very hard to maintain for human programmers, bugs are harder to find if it performs multiple functionalities, programmers need to make multiple methods instead. Since the whole project is completely modular with different functionalities organised into different modules, the system has high cohesion and low coupling, therefore simple to read and maintain.

3. Open Closed Design Principle: Classes, methods or functions should be Open for extension (new functionality) and Closed for modification. All the classes in the project can be extended by inheriting and overriding the existing functions, but trying to modify the classes and its methods will break the system and cause other unforeseen issues.

4. Single Responsibility Principle (SRP): As per SRP, there should not be more than one reason for a class to change, or a class should always handle single functionality. An example where the above principle was used in the database API’s where each API performs only a single user functionality like fetching userID, inserting parkingLotSelected, etc.

5. The Composition Over Inheritance Principle: One should often prefer composition over inheritance when designing their systems. In Java, this means that we should more often define interfaces and implement them, rather than defining classes and extending them. This principle was used throughout the project where objects of the database were created inside the classes using it, instead of inheriting the functionalities of the database class. Another example where this principle was used was using the objects of the view and controller of various modules during the current frame dispose function and calling the next frame by using the view and controller of the required module.

# Installation and Running

- Clone the repository

- Open the application as a Java Maven Project

- In the terminal run

```python
pip install geocoder
pip install geopy
```

- cd src/main/java/com/parkingmvc/

- In Line 16 in `src/main/java/com/parkingmvc/GeoLocation/GeoLocationModel.java` change the absolute path of `GeoLocater.py` file

```java
String command = "python /Users/adithya-ms/Desktop/ParkingSystemMVC/parkingsystemmvc/src/main/java/com/parkingmvc/GeoLocation/GeoLocater.py";
```

- Run the `app.java`

- Use MongoDB compass to get a better view of all the database activities

# LICENSE
MIT



