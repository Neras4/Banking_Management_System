import java.util.List;
import java.util.Scanner;

public class AccountsManagementMethods {
    private static final Scanner scanner = new Scanner(System.in);

    public static void addAccount(List<BankAccount> accounts) {
        System.out.println("\nAdding new account:");
        String id = promptNumeric("Enter ID:");

        for (BankAccount account : accounts) {
            if (account.getId().equals(id)) {
                System.out.println("An account with the same ID already exists. Cannot add duplicate accounts.");
                return;
            }
        }
        String firstName = promptAlphabetic("Enter First Name:");
        String secondName = promptAlphabetic("Enter Second Name:");
        double balance = promptDouble("Enter balance:");

        BankAccount newAccount = new BankAccount(id, firstName, secondName, balance);
        accounts.add(newAccount);
        System.out.println("Account added successfully");
    }


    public static void removeAccount(List<BankAccount> accounts) {
        System.out.println("\nRemoving account:");
        String id = promptNumeric("Enter Account ID:");
        String firstName = promptAlphabetic("Enter First Name:");
        String secondName = promptAlphabetic("Enter Second Name:");

        boolean removed = accounts.removeIf(account ->
                account.getId().equals(id) &&
                        account.getFirstName().equals(firstName) &&
                        account.getSecondName().equals(secondName));

        if (removed) {
            System.out.println("Account removed successfully");
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void depositBalance(List<BankAccount> accounts) {
        System.out.println("\nDeposit balance:");
        String id = promptNumeric("Enter Account ID:");
        String firstName = promptAlphabetic("Enter First Name:");
        String secondName = promptAlphabetic("Enter Second Name:");
        double deposit = promptDouble("Enter deposit value:");

        BankAccount account = findAccount(accounts, id, firstName, secondName);
        if (account != null) {
            account.depositBalance(deposit);
            System.out.println("The balance has been increased successfully");
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void withdrawBalance(List<BankAccount> accounts) {
        System.out.println("\nWithdraw balance:");
        String id = promptNumeric("Enter Account ID:");
        String firstName = promptAlphabetic("Enter First Name:");
        String secondName = promptAlphabetic("Enter Second Name:");
        double withdraw = promptDouble("Enter withdraw value:");

        BankAccount account = findAccount(accounts, id, firstName, secondName);
        if (account != null) {
            if (account.getBalance() >= withdraw && account.getBalance() - withdraw >= 0) {
                account.withdrawBalance(withdraw);
                System.out.println("The balance has been withdrawn successfully");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void accountBalance(List<BankAccount> accounts) {
        System.out.println("\nAccount balance:");
        String id = promptNumeric("Enter Account ID:");
        String firstName = promptAlphabetic("Enter First Name:");
        String secondName = promptAlphabetic("Enter Second Name:");

        BankAccount account = findAccount(accounts, id, firstName, secondName);
        if (account != null) {
            System.out.println("Account balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public static void listAccounts(List<BankAccount> accounts) {
        System.out.println("\nListing Accounts");
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
        } else {
            for (BankAccount account : accounts) {
                System.out.println(account);
            }
        }
    }

    public static void searchAccount(List<BankAccount> accounts) {
        String id = null, firstName = null, secondName = null;

        System.out.println("\nSearching Account:");
        String searchCriteria = promptAlphabetic("Search by ID or Name?");

        if (searchCriteria.equalsIgnoreCase("ID")) {
            id = promptNumeric("Enter Account ID:");
        } else if (searchCriteria.equalsIgnoreCase("Name")) {
            firstName = promptAlphabetic("Enter First Name:");
            secondName = promptAlphabetic("Enter Second Name:");
        } else {
            System.out.println("Please enter: ID or Name");
        }

        for (BankAccount account : accounts) {
            if (account.getId().equals(id) ||
                    account.getFirstName().equals(firstName) &&
                    account.getSecondName().equals(secondName)) {
                System.out.println(account);
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static String promptNumeric(String message) {
        System.out.println(message);
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (!input.matches("\\d+")) {
                System.out.println("Invalid input. Please enter only numeric characters.");
            } else {
                break;
            }
        }
        return input;
    }

    private static String promptAlphabetic(String message) {
        System.out.println(message);
        String input;
        while (true) {
            input = scanner.nextLine().trim();
            if (!input.matches("[a-zA-Z ]+")) {
                System.out.println("Invalid input. Please enter only English alphabetic characters.");
            } else {
                break;
            }
        }
        return input;
    }

    private static double promptDouble(String message) {
        while (true) {
            try {
                System.out.println(message);
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private static BankAccount findAccount(List<BankAccount> accounts, String id, String firstName, String secondName) {
        for (BankAccount account : accounts) {
            if (account.getId().equals(id) &&
                    account.getFirstName().equals(firstName) &&
                    account.getSecondName().equals(secondName)) {
                return account;
            }
        }
        return null;
    }
}
