## Java Internship Tasks

---

## Author

**Name:** Tushar Kumar

**Internship provided by:** Codveda Technologies

**Duration:** November 2025

**Role**: Java Development Intern

---
## Basic Task 1: Basic Calculator

### Description
A simple Java console application that performs **basic arithmetic operations** - Addition, Subtraction, Multiplication, Division - based on user input.

#### This project demonstrate how to:
- Create and structure a java class with separate methods for each operation. 
- Accept user inputs using the scanner class. 
- Handle invalid inputs and division by zero cases gracefully. 
- Display meaningful output in the console.

---

###  Objectives
- Create a class with methods for each arithmetic operation.
- Take input from the user for numbers and the desired operation.
- Handle edge cases like division by zero.

---

## Basic Task 2 : Number Guessing Game

### Description
A Java console game where the computer randomly selects a number and the user must guess it within a limited number of attempts. 

#### This project demonstrate how to:
- Generates a random number between 1 and 100.
- Uses loops and conditionals to check each guess.
- Ends when the user guesses correctly or runs out of attempts.
---
###  Objectives
- Use Java's `Random` class to generate a random number 
- Provide feedback like *"too high"*, *"too low"* or *"correct"*
- Limit the number of attempts
- Handle invalid (non-numeric) inputs

---
## Basic Task 3 :  Factorial Calculation using Recursion

### Description
A Java console application that calculates factorial of a given number using recursion.

#### This project demonstrate how to:
- Implements recursive functions in Java.
- Handles base and recursive cases effectively.
- Manage invalid inputs such as negative numbers.
---
###  Objectives
- Implement a recursive method to compute the factorial. 
- Handle edges cases like factorial of 0 = 1.
- Display appropriate messages for negative numbers or invalid inputs.

---

## Intermediate Task 1 : Employee Management System

### Description
A Java console-based application that manages employee records using Object-Oriented Programming (OOP) concept.
It allows user to perform CRUD (Create, Read, Update, Delete) operations on employee data stored in memory.

#### This project demonstrate how to:
- Create and uses classes and objects in Java.
- Manage data using collections like `Arraylist`.
- Implement CRUD functionality with user interaction via the console.
- Handle invalid inputs and edge cases effectively.

---
### Objectives
- Define an `Employee` class with fields such as ID, Name and Salary.
- Implements methods to Add, View, Update and Delete employee records.
- Use `ArrayList` to store employee data dynamically.
- Apply control structure `loops, conditionals, switch` for user menu navigation.
- Handle invalid or duplicate entries gracefully.

---

## Intermediate Task 2 : File Handling - Reading and Writing to a file

### Description
A Java console-based application that demonstrate file handling by reading data form one text file, processing it (counting line and words) and writing the summary to another file. 

#### This project demonstrate how to:
- Uses Java's `BufferReader` and `BufferWriter` for file I/O operations.
- Read content line by line from an input file.
- Process text to count total lines and words.
- Write the processed summary into an output file.
- Handle file-related exceptions such as `FileNotFoundException` and `IOException`.

---
### Objectives
- Read a text file and count the number of lines and words.
- Write the processed output to a new file.
- Handle exceptions gracefully to ensure reliable file operations.
- Display the summary result in the console for quick verification.

---

## Intermediate Task 3 : Simple Banking Application

### Description
A Java console-based application that simulates simple banking operations such 
as depositing money, withdrawing funds and checking account balance.

#### This project demonstrate how to:
- Implement a `BankAccount` class with private fields and public methods.
- Use Java methods for deposit, withdrawal and balance checking.
- Applying condition checks (e.g.,insufficient balance).
- Create a menu-driven console interface for user interaction.
- Handle invalid inputs gracefully to avoid runtime issues.

---
### Objectives
- Create a `BankAccount` class with `deposit()`, `withdraw()` and `checkBalance()`.
- Validate transactions to prevent invalid or insufficient withdrawals.
- Simulate continuous user interaction using loops and console input. 
- Display clear transactions messages and updated balance information.

---
## Advanced Task 1 : Library Management System

### Description
A Java console-based application that manages library operations 
such as adding books, registering users, borrowing and returning 
books and viewing transactions. 

#### This project demonstrate how to:
- Implement a `Book`, `User`, and `Transaction` model classes.
- Build DAO (Data Access Object) layers for database interactions.
- Use MySQL with JDBC for CRUD operations.
- Manage book availability and quantity updates dynamically.
- Record all borrowing and returning activities using a transaction logs.
- Create a clean, menu-driven console interface for user interaction.
- Handle invalid data inputs and missing records gracefully.

---
### Objectives
- Design tables in MySQL (`books`, `users`, `transactions`) and connect them using JDBC.
- Implement methods to : `addBooks()`, `addUser()`, `borrowBook()`,`returnBook()`, `getAllBooks()`, `getAllUsers()`, `getAllTransactions()`.
- Maintain book quantity and availability automatically.
- Log every borrow/return operations in transactions table.
- Provide continuously interactive console-based menu until exit.
- Ensure proper error messages when book/users are not found.

---
## Advanced Task 2 : Multi-Threaded Chat Application

### Description
A Java console-based chat system that enables multiple users to communicate
with each other in real-time using `multithreading` and `Java Sockets`.

#### This project demonstrate how to:
- Implement a `Chat Server` to handle incoming client connections.
- Use `Client Handler` threads to manage multiple clients simultaneously.
- Build a `Chat Client` program that sends and receives messages on separate threads. 
- Manage book availability and quantity updates dynamically.
- Apply Socket programming `Server Socket`,`Socket` for networking.
- Use Input/Output streams for continuous message transfer.
- Create a real-time broadcast system for all connected clients.
- Handle client disconnections gracefully without stopping the server.

---
### Objectives
- Implement a server that listen for clients using `Server Socket`.
- Create a multithreaded architecture using a `Client Handler` class.
- Allow each client to send and receive real-time messages through the server.
- Broadcast one client's message to all other connected clients.
- Maintain continuous communication until `exit` is typed by the user.
- Display proper server and client messages (connection, disconnection, errors).
- Support multiple client instances using IntelliJ's `Allow multiple instances` option. 

---

## Folder Structure

```
Java-Internship-Tasks
|--- src
|    |--- tasks
|            |--- basics
|            |    |--- Calculator
|            |    |--- NumberGuessingGame
|            |    |--- Factorial
|            |--- intermediate
|            |    |--- EmployeeManagementSystem
|            |    |--- FileHandlingTask
|            |    |--- BankingAppTask
|            |--- advanced
|            |    |--- Library
|            |    |     |--- app          ---> includes main file
|            |    |     |--- dao          ---> includes (Bank, Transaction, User) DAO
|            |    |     |--- models       ---> includes Bank, Transaction, User files
|            |    |     |--- service      ---> includes Library services
|            |    |     |--- DBConnection ---> connected to mysql
|            |    |--- Chat Application
|            |    |     |--- Chat Client   ---> Client Program
|            |    |     |--- Chat Server   ---> Main server
|            |    |     |--- Chat Handler  ---> Thread Handler for each Client
|--- sql
|    |---library_db
|--- README.md

```
---
## Technologies Used

- *Language*          : Java
- *IDE*               : IntelliJ IDEA 
- *Java Version*      : 17+
- *Database*          : MySQL
- *Database Connector*: JDBC (MySQL Connector/J)
- *Architecture*      : DAO (Data Access Object) Pattern
- *Build/Execution*   : JDK compiler & Console-based application 

---
## LinkedIn Profile
Tushar Kumar - [https://www.linkedin.com/in/tushar-kumar-developer/]