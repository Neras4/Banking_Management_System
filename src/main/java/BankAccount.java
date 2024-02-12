public class BankAccount {
    private String id;
    private String firstName;
    private String secondName;
    private double balance;

    public BankAccount(String id, String firstName, String secondName, double balance) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public double getBalance() {
        return balance;
    }

    public void depositBalance(double amount) {
        this.balance = this.balance + amount;
    }

    public void withdrawBalance(double amount) {
        this.balance = this.balance - amount;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", First Name: " + firstName + ", Second Name: " + secondName + ", Balance: $" + balance;
    }
}
