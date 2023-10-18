# Transaction Management System

The Transaction Management System is a Java-based web application that allows users to manage and view transaction data for both parent and child transactions. This README provides an overview of the project structure, components, and instructions for running the application.

## Table of Contents

- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [How to Run](#how-to-run)
- [Usage](#usage)

## Project Structure

The project is organized into several packages and components:

- `com.daofab.transactions.controller`: Contains controllers for handling HTTP requests.
- `com.daofab.transactions.model`: Defines data models for transactions.
- `com.daofab.transactions.repository`: Provides repositories for data access.
- `com.daofab.transactions.service`: Implements services for handling business logic.
- `com.daofab.transactions.utils`: Contains utility classes for pagination.
- `src/main/resources`: Includes static files and JSON data used in the application.

## Prerequisites

Before running the application, make sure you have the following prerequisites installed:

- Java Development Kit (JDK)
- Apache Maven
- An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse

## How to Run

Follow these steps to run the Transaction Management System:

1. Clone the repository to your local machine.

2. Open the project in your preferred IDE.

3. Build the project using Maven. You can do this from the command line or within your IDE.

4. Run the application from your IDE:
- Right-click on the CodingAssignmentForDaofabApplication class.
- Select "Run" or "Debug."
- Once the application is running, you can access it in your web browser at http://localhost:8080.

5. Before using the application, you need to load all transactions:

- Use the endpoint http://localhost:8080/api/transactions/loadAllTransactions.

## Usage

### Parent Transactions

- Access the list of parent transactions: http://localhost:8080/api/transactions/parent/all
- To view child transactions for a parent transaction, click on the "Total Paid Amount" value.
- You can use pagination on the parent transactions page to navigate to the next or previous page of the parent transactions.

### Child Transactions

- Access the list of child transactions: http://localhost:8080/api/transactions/child/all
