package DIO.Desafios.account.entities;

public class BanckAccount{
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    private double overdraftLimit;

    public BanckAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        if (balance >= 500.0){
            this.overdraftLimit = 50.0;
        } else {
            this.overdraftLimit = balance * 0.50;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getBalance() {
        return balance;
    }
    public boolean ConsultarSaldo(double balance) {
        if (balance < 0) {
            System.out.println("Balance cannot be negative.");
            return false;
        }
        System.out.println("Current balance: " + balance);
        return true;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}
