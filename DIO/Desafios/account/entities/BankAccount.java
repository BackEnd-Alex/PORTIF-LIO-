package DIO.Desafios.account.entities;

import java.util.Date;

public class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;
    private double overdraftLimit;

    public BankAccount(String accountNumber, String accountHolderName,
                       double balance, double overdraftLimit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        if (balance > 500.0) {
            this.overdraftLimit = 50.0;
        } else {
            this.overdraftLimit = balance * 0.5;
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

    public boolean consultarSaldo() {
        if (balance < 0) {
            System.out.println("Balance cannot be negative.");
            return false;
        }
        System.out.println("Current balance: " + balance);
        return true;
    } // depositar dinheiro.

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    } // sacar dinheiro.

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException
                ("Withdrawal amount must be positive.");
        if (amount > 0 && amount <= (balance + overdraftLimit)) throw new IllegalArgumentException
                ("Withdrawal amount exceeds overdraft limit.");
        {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
    }

    public boolean payBill(double billAmount, Date dueDate) {
        Date vencimento = new Date(); // Simulando a data de vencimento do boleto
        if (dueDate.before(new Date())) throw new IllegalArgumentException("Boleto vencido.");
        {
            if (billAmount > balance + overdraftLimit) return false;
            {
                balance -= billAmount;
                return true;
            }
        }

    }
    public double getUsedOverdraft() {
        return balance < 0 ? Math.abs(balance) : 0.0;
    }
}