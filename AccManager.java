import java.util.*;

public class AccManager {
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
        System.out.println("Account Created Successfully! Your Account ID is: " + acc.accountId);
    }

    Account findAccountById(int id) {
        for (Account acc : accounts) {
            if (acc.accountId == id) return acc;
        }
        return null;
    }

    void performOperations() {
        while (true) {
            System.out.println(" MENU ");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

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

                switch (choice) {
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        acc.deposit(Double.parseDouble(sc.nextLine()));
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        acc.withdraw(Double.parseDouble(sc.nextLine()));
                        break;
                    case 4:
                        acc.showBalance();
                        break;
                    case 5:
                        acc.displayDetails();
                        break;
                }
            } else if (choice == 6) {
                System.out.println("Thank you for using the system.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}
