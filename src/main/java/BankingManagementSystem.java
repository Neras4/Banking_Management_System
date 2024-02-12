import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankingManagementSystem {
    private static final List<BankAccount> accounts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    \nBanking Management System:
                    1: Add account.
                    2: Remove account.
                    3: Deposit balance.
                    4: Withdraw balance.
                    5: Account balance.
                    6: List accounts.
                    7: Search account.
                    8: Exit.\n""");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> AccountsManagementMethods.addAccount(accounts);
                case 2 -> AccountsManagementMethods.removeAccount(accounts);
                case 3 -> AccountsManagementMethods.depositBalance(accounts);
                case 4 -> AccountsManagementMethods.withdrawBalance(accounts);
                case 5 -> AccountsManagementMethods.accountBalance(accounts);
                case 6 -> AccountsManagementMethods.listAccounts(accounts);
                case 7 -> AccountsManagementMethods.searchAccount(accounts);
                case 8 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 8.");
            }
        }
    }
}
