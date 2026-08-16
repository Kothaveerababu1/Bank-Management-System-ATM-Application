# Bank-Management-System-ATM-Application
# 🏦 Bank Management System

A desktop-based **Bank Management System / ATM Application** developed using **Java Swing, JDBC, and MySQL**. The project provides a graphical interface for customer account creation and common ATM banking operations such as deposit, withdrawal, fast cash, balance enquiry, mini statement, and PIN change.

This project was developed as a learning project to understand **Java GUI development, event handling, JDBC database connectivity, SQL operations, and basic banking transaction management**.

---

## 📌 Features

### 🔐 Login System

* Login using card number and PIN.
* Clear card number and PIN fields.
* New users can proceed to account registration.
* Successful login opens the transaction dashboard.

### 📝 New Account Registration

The account creation process is divided into three pages.

#### Page 1 — Personal Details

Users can enter:

* Name
* Father's Name
* Date of Birth
* Gender
* Email Address
* Marital Status
* Address
* City
* State
* Pincode

A unique application form number is generated during registration.

#### Page 2 — Additional Details

Users can provide:

* Religion
* Category
* Income
* Education Qualification
* Occupation
* PAN Number
* Aadhaar Number
* Senior Citizen status
* Existing Account status

#### Page 3 — Account Details

Users can select:

* Savings Account
* Fixed Deposit Account
* Current Account
* Recurring Deposit Account

The system also generates:

* Card Number
* PIN

Users can select additional banking facilities such as:

* ATM Card
* Internet Banking
* Mobile Banking
* Email/SMS Alerts
* Cheque Book
* E-Statement

---

## 💳 ATM Transaction Features

After successful login, the user is taken to the transaction menu.

### 💰 Deposit

Users can enter an amount and deposit money into their account.

### 💸 Withdrawal

Users can enter an amount to withdraw from their account.

### ⚡ Fast Cash

Provides predefined withdrawal options:

* ₹100
* ₹500
* ₹1,000
* ₹2,000
* ₹5,000
* ₹10,000

The Fast Cash module also checks the available balance before processing the withdrawal.

### 📊 Balance Enquiry

Displays the current account balance by calculating deposits and withdrawals recorded in the database.

### 📄 Mini Statement

Displays:

* Transaction date
* Transaction type
* Transaction amount
* Current account balance
* Masked card number

### 🔑 PIN Change

Users can change their existing PIN by entering and confirming a new PIN.

The new PIN is updated in the relevant database records.

### 🚪 Exit

Allows the user to exit the ATM application.

---

## 🛠️ Technologies Used

| Technology     | Purpose                                         |
| -------------- | ----------------------------------------------- |
| **Java**       | Core application development                    |
| **Java Swing** | Graphical User Interface                        |
| **Java AWT**   | UI components, fonts, colors and event handling |
| **JDBC**       | Communication between Java and MySQL            |
| **MySQL**      | Database management                             |
| **JCalendar**  | Date selection using `JDateChooser`             |
| **SQL**        | Storing and retrieving banking data             |

The project uses `JDateChooser` for selecting the user's date of birth during account registration.

---

## 🏗️ Project Architecture

The application follows a simple desktop application architecture:

```text
User
  │
  ▼
Login Screen
  │
  ├── New User
  │      │
  │      ▼
  │   Signup Page 1
  │      │
  │      ▼
  │   Signup Page 2
  │      │
  │      ▼
  │   Signup Page 3
  │      │
  │      ▼
  │   Card Number + PIN
  │
  └── Existing User
         │
         ▼
   Transaction Menu
         │
         ├── Deposit
         ├── Withdrawal
         ├── Fast Cash
         ├── Balance Enquiry
         ├── Mini Statement
         ├── PIN Change
         └── Exit
```

---

## 📂 Project Structure

```text
BankManagementSystem/
│
├── src/
│   └── bankmanagement/
│       ├── Login.java
│       ├── Conn.java
│       ├── Signupone.java
│       ├── Signuptwo.java
│       ├── Signupthree.java
│       ├── Transaction.java
│       ├── Deposit.java
│       ├── Withdrawl.java
│       ├── Fastcash.java
│       ├── BalanceEnquiry.java
│       ├── MiniStatement.java
│       └── Pinchange.java
│
├── icons/
│   ├── atm.jpg
│   └── logo.jpg
│
├── README.md
└── .gitignore
```

> The exact folder structure may vary depending on the IDE used.

---

## 🗄️ Database

The application uses a MySQL database named:

```text
bankmanagementsystem
```

The Java application connects to MySQL using JDBC.

The project uses the following logical tables:

### `signup`

Stores the personal details entered during the first registration page.

Main information includes:

* Application/Form Number
* Name
* Father's Name
* Date of Birth
* Gender
* Email
* Marital Status
* Address
* City
* State
* Pincode

### `signuptwo`

Stores additional customer information.

Includes:

* Form Number
* Religion
* Category
* Income
* Education
* Occupation
* PAN
* Aadhaar
* Senior Citizen
* Existing Account

### `signupthree`

Stores account-related information.

Includes:

* Form Number
* Account Type
* Card Number
* PIN
* Selected Facilities

### `login`

Stores login information required for ATM authentication.

### `bank`

Stores transaction information such as:

* PIN
* Transaction Date
* Transaction Type
* Amount

The application records deposits as `Deposit` and withdrawals as `Withdrawl`.

---

## ⚙️ Requirements

Before running the project, install:

1. **Java JDK**
2. **MySQL Server**
3. **MySQL Connector/J**
4. **JCalendar library**
5. A Java IDE such as IntelliJ IDEA, Eclipse, or NetBeans

---

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone <your-github-repository-url>
```

### 2. Open the Project

Open the project in your preferred Java IDE.

### 3. Configure MySQL

Create the database:

```sql
CREATE DATABASE bankmanagementsystem;
```

Create the required tables according to the fields used by the Java source files.

### 4. Configure Database Connection

Open:

```text
Conn.java
```

Configure your own MySQL username, password, and database connection.

**Do not upload real database passwords or credentials to GitHub.**

### 5. Add Required Libraries

Make sure the project has:

* MySQL Connector/J
* JCalendar

The JCalendar library is required because the registration page uses:

```java
JDateChooser
```

### 6. Add Image Resources

The application expects image resources such as:

```text
icons/atm.jpg
icons/logo.jpg
```

Make sure these files are available in the correct resources/classpath location.

### 7. Run the Application

Start the application from:

```text
Login.java
```

The login screen will open first.

---

## 🔄 Application Flow

```text
Start Application
       │
       ▼
    Login
       │
       ├───────────────┐
       │               │
       ▼               ▼
   Sign Up          Sign In
       │               │
       ▼               ▼
  Page 1           Transaction
       │               │
       ▼               ├── Deposit
  Page 2              ├── Withdrawal
       │               ├── Fast Cash
       ▼               ├── Balance Enquiry
  Page 3              ├── Mini Statement
       │               ├── PIN Change
       ▼               └── Exit
 Card + PIN
       │
       ▼
    Deposit
```

---

## 💡 Key Learning Outcomes

Through this project, the following concepts were implemented:

* Java Object-Oriented Programming
* Java Swing GUI development
* Event-driven programming
* Action listeners
* JFrame and Swing components
* Radio buttons and checkboxes
* Form validation
* Random number generation
* JDBC connectivity
* MySQL database operations
* SQL `INSERT`, `SELECT`, and `UPDATE` operations
* Transaction record management
* Basic balance calculation
* Multi-page registration workflow

---

## 🔒 Security Note

This project is intended for **educational purposes** and is not production-ready banking software.

For a production-level implementation, the following improvements would be required:

* Use `PreparedStatement` instead of constructing SQL queries through string concatenation.
* Store database credentials securely using environment variables or a configuration system.
* Hash/encrypt sensitive credentials such as PINs.
* Add stronger input validation.
* Add proper database transactions and rollback handling.
* Use secure random generation for sensitive credentials.
* Add proper authentication and authorization mechanisms.
* Improve error handling and logging.

---

## 🚧 Future Improvements

Some possible improvements for future versions include:

* [ ] Add money transfer between accounts
* [ ] Add account balance validation for all withdrawal operations
* [ ] Add transaction search and filtering
* [ ] Add transaction date/time sorting
* [ ] Add customer profile management
* [ ] Add account closing functionality
* [ ] Add admin dashboard
* [ ] Add email/SMS notification support
* [ ] Improve UI/UX design
* [ ] Add stronger form validation
* [ ] Replace SQL string concatenation with `PreparedStatement`
* [ ] Secure sensitive information using environment variables
* [ ] Add proper exception handling and logging

---

## 🎯 Project Objective

The main objective of this project is to develop a simple desktop-based banking application that demonstrates how a Java GUI application can communicate with a relational database to perform basic banking operations.

It combines **Java Swing for the frontend**, **JDBC for database connectivity**, and **MySQL for data storage** to create an interactive ATM-style banking system.

---

## 👨‍💻 Author

**Veerababu Kotha**

B.Tech — Computer Science & Engineering
AI & Machine Learning

---

## 📜 License

This project is created for educational and learning purposes. You are free to study and modify the code for personal learning and development.
