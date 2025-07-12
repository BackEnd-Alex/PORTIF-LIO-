package DIO.Desafios.account.entities;

public class BanckAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public BanckAccount(String accountNumber, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        double chequeEspecial;
        if(balance <= 500.0){
         chequeEspecial = 50.0;
        }else {
           chequeEspecial = balance * 0.50;
       }
        this.balance = getBalance(); // Initial balance is set to zero
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
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
