class Account {
    static int idCounter = 1;

    int accountId;
    String name;
    String email;
    String phone;
    String bank;
    double balance;

    Account(String name, String email, String phone, String bank) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bank = bank;
        this.balance = 0.0;
        this.accountId = idCounter++;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void displayDetails() {
        System.out.println("Account ID: " + accountId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Bank: " + bank);
        System.out.println("Balance: " + balance);
    }
}
