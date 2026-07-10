# Task 3: ATM Interface

## Overview
This project simulates a real-world ATM machine interface using Object-Oriented Programming (OOP) in Java. It allows users to check their bank account balance, safely deposit funds, and withdraw money while ensuring all transactions are valid.

## Features
- **Interactive UI:** A console-based menu system that loops until the user chooses to exit.
- **Robust Validation:** 
  - Prevents withdrawals if the account balance is insufficient.
  - Prevents negative deposits or withdrawals.
  - Catches invalid inputs (e.g., typing text when a number is expected) without crashing the program.
- **Separation of Concerns:** Uses distinct classes to model the problem accurately:
  - `BankAccount.java`: Represents the core financial data and transaction logic.
  - `ATM.java`: Handles user interaction, input parsing, and presentation.

## How to Run
Ensure you have the Java Development Kit (JDK) installed. Open your terminal in the root directory and compile/run the program:

```bash
# Compile
javac task3_atm_interface/*.java

# Run
java task3_atm_interface.Main
```
