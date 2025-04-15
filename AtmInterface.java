import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + String.format("%.2f", balance));
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", balance));
            } else {
                System.out.println("Insufficient funds for this withdrawal.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

// Class to represent the ATM machine
class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void run() {
        System.out.println("Welcome to the ATM!");

        while (true) {
            displayMenu();
            System.out.print("Please select an option (1-4): ");
            
            try {
                int choice = scanner.nextInt();
                
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        processDeposit();
                        break;
                    case 3:
                        processWithdrawal();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + String.format("%.2f", account.getBalance()));
    }

    private void processDeposit() {
        System.out.print("Enter deposit amount: $");
        try {
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
    }

    private void processWithdrawal() {
        System.out.print("Enter withdrawal amount: $");
        try {
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Invalid amount. Please enter a valid number.");
            scanner.next(); // Clear the invalid input
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        // Create a bank account with initial balance
        BankAccount userAccount = new BankAccount(1000.00);
        
        // Create ATM and connect it to the bank account
        ATM atm = new ATM(userAccount);
        
        // Run the ATM interface
        atm.run();
    }
}