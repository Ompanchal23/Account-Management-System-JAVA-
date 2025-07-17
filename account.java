import java.util.Random;

public class Account {
    String name, email, phone, bankName;
    static int idCounter = 1000;
    int accountId;
    String accountNumber;
    double balance = 0.0;

    public Account(String name, String email, String phone, String bankName) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bankName = bankName;
        this.accountId = idCounter++;
        this.accountNumber = "AC" + new Random().nextInt(100000);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited ₹" + amount + ". Current Balance: ₹" + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn ₹" + amount + ". Current Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    void showBalance() {
        System.out.println("Available Balance: ₹" + balance);
    }

    void displayDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Bank: " + bankName);
        System.out.println("Balance: ₹" + balance);
    }
}
