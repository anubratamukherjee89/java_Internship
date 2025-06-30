import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder, String accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created for " + accountHolder + " (Acc: " + accountNumber + ")");
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: ₹" + amount);
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (String record : transactionHistory) {
            System.out.println("- " + record);
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account Holder Name:");
        String name = sc.nextLine();

        System.out.println("Enter Account Number:");
        String accNumber = sc.nextLine();

        Account userAccount = new Account(name, accNumber);

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmt = sc.nextDouble();
                    userAccount.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmt = sc.nextDouble();
                    userAccount.withdraw(withdrawAmt);
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + userAccount.getBalance());
                    break;

                case 4:
                    userAccount.printTransactionHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using the Bank App!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
