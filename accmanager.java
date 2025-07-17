import java.util.*;

class AccManager {
    List<Account> accounts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void createAccount() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Bank Name: ");
        String bank = sc.nextLine();

        Account acc = new Account(name, email, phone, bank);
        accounts.add(acc);
        System.out.println("Account Created. ID: " + acc.accountId);
    }

    Account findAccountById(int id) {
        for (Account acc : accounts) {
            if (acc.accountId == id) return acc;
        }
        return null;
    }

    void menu() {
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Details");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input.");
                continue;
            }

            if (choice == 1) {
                createAccount();
            } else if (choice >= 2 && choice <= 5) {
                System.out.print("Enter Account ID: ");
                int id;
                try {
                    id = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid ID.");
                    continue;
                }

                Account acc = findAccountById(id);
                if (acc == null) {
                    System.out.println("Account not found.");
                    continue;
                }

                if (choice == 2) {
                    System.out.print("Amount to deposit: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    acc.deposit(amt);
                } else if (choice == 3) {
                    System.out.print("Amount to withdraw: ");
                    double amt = Double.parseDouble(sc.nextLine());
                    acc.withdraw(amt);
                } else if (choice == 4) {
                    acc.showBalance();
                } else {
                    acc.displayDetails();
                }
            } else if (choice == 6) {
                System.out.println("Goodbye.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
