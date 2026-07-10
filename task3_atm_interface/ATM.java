package task3_atm_interface;

import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        System.out.println("Welcome to the ATM!");

        while (!exit) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    handleWithdrawal();
                    break;
                case "2":
                    handleDeposit();
                    break;
                case "3":
                    handleCheckBalance();
                    break;
                case "4":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void handleWithdrawal() {
        System.out.print("Enter amount to withdraw: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (account.withdraw(amount)) {
                System.out.printf("Successfully withdrew $%.2f. New balance is $%.2f%n", amount, account.getBalance());
            } else {
                System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: $");
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            if (account.deposit(amount)) {
                System.out.printf("Successfully deposited $%.2f. New balance is $%.2f%n", amount, account.getBalance());
            } else {
                System.out.println("Deposit failed. Amount must be positive.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private void handleCheckBalance() {
        System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
    }
}
