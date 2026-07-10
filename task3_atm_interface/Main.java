package task3_atm_interface;

public class Main {
    public static void main(String[] args) {
        // Initialize an account with a starting balance
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
