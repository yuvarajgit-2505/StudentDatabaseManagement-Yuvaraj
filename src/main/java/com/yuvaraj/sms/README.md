# Student Database Management System

## 📚 Project Overview

The Student Database Management System is a Java-based application that manages student records, allowing you to add, update, delete, and view student information with MySQL database integration. It streamlines the management of student data while ensuring data integrity and ease of access.

## 🛠️ Technologies Used

- Java
- MySQL
- JDBC
- Maven
- IntelliJ IDEA (optional)

## ⚙️ Features

- Add new student records
- Update existing student records
- Delete student records
- View student details
- Database integration with MySQL

## 🚀 Setup Instructions

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL Server installed and running
- Maven for project build and dependency management
- IDE such as IntelliJ IDEA (recommended)

### Steps to Run the Project

1. **Clone the Repository**

```bash
git clone https://github.com/yuvarajgit-2505/StudentDatabaseManagement-Yuvaraj.git
cd StudentDatabaseManagement-Yuvaraj
```

2. **Create the Database in MySQL**

```sql
CREATE DATABASE student_db;
```

3. **Import SQL Tables**

- If your project includes a SQL file, import it to create the required tables.

4. **Update Database Connection**

- Open `DBConnection.java`.
- Update the database URL, username, and password to match your MySQL setup.

5. **Build and Run the Project**

```bash
mvn clean install
```

- Run the main class through your IDE or terminal.

## 📂 Project Structure

```
src/
├─ main/java/com/studentdb/
│  ├─ Main.java
│  ├─ Student.java
│  ├─ DBConnection.java
│  └─ StudentDAO.java
└─ test/java/com/studentdb/
   └─ StudentTest.java
```

## 🧪 Testing

- Unit tests are located in the `src/test/java` directory.
- To run tests:

```bash
mvn test
```

## 💡 How to Use

- After running the program, you can:
    - Add a new student record
    - Update existing student details
    - Delete student records
    - View student information
