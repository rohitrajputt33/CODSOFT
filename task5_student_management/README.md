# Task 5: Student Management System

## Overview
This project is a comprehensive Student Management System that allows for the creation, retrieval, updating, and deletion (CRUD) of student records. It utilizes Java File I/O to ensure that student data is saved locally and persists between application sessions.

## Features
- **Full CRUD Functionality:** 
  - Add new students with Name, Roll Number, and Grade.
  - Remove existing students by their Roll Number.
  - Search for specific students.
  - Display a formatted list of all registered students.
- **Data Persistence:** Implements `Serializable` to automatically save the student list to a local `students.dat` file. When the application restarts, it reads this file to restore the data.
- **Input Validation:** Ensures that no critical fields (like Name or Roll Number) are left empty during registration.

## How to Run
Ensure you have the Java Development Kit (JDK) installed. Open your terminal in the root directory and compile/run the program:

```bash
# Compile
javac task5_student_management/*.java

# Run
java task5_student_management.SMSApp
```
