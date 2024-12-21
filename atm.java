
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atm {

    private double balance;
    private String pin;
    private List<String> transactionHistory;

    public atm() {
        this.balance = 0.0;
        this.pin = "1234"; // Default PIN
        this.transactionHistory = new ArrayList<>();
    }

    public void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Account Balance Inquiry");
        System.out.println("2. Cash Withdrawal");
        System.out.println("3. Cash Deposit");
        System.out.println("4. Change PIN");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
    }

    public void accountBalanceInquiry() {
        System.out.printf("Your current balance is: $%.2f%n", balance);
    }

    public void cashWithdrawal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Please enter a positive amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + String.format("%.2f", amount));
            System.out.printf("Please take your cash: $%.2f%n", amount);
        }
    }

    public void cashDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Please enter a positive amount.");
        } else {
            balance += amount;
            transactionHistory.add("Deposited: $" + String.format("%.2f", amount));
            System.out.printf("You have deposited: $%.2f%n", amount);
        }
    }

    public void changePin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new PIN (4 digits): ");
        String newPin = scanner.next();
        if (newPin.length() == 4 && newPin.matches("\\d+")) {
            pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid PIN. Please enter a 4-digit numeric PIN.");
        }
    }

    public void transactionHistoryDisplay() {
        System.out.println("\n--- Transaction History ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            displayMenu();
            System.out.print("Select an option (1-6): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    accountBalanceInquiry();
                    break;
                case 2:
                    cashWithdrawal();
                    break;
                case 3:
                    cashDeposit();
                    break;
                case 4:
                    changePin();
                    break;
                case 5:
                    transactionHistoryDisplay();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        atm atm = new atm();
        atm.run();
    }
}
