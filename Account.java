public class Account {
    private static int counter = 1000;
    public final int accountId;
    private String name;
    private String email;
    private String phone;
    private String bank;
    private double balance;

    public Account(String name, String email, String phone, String bank) {
        this.accountId = counter++;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bank = bank;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void displayDetails() {
        System.out.println("==== Account Details ====");
        System.out.println("Account ID : " + accountId);
        System.out.println("Name       : " + name);
        System.out.println("Email      : " + email);
        System.out.println("Phone      : " + phone);
        System.out.println("Bank       : " + bank);
        System.out.println("Balance    : ₹" + balance);
    }
}
