package DIO.Desafios.account.application;

import DIO.Desafios.account.entities.BanckAccount;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        // Create a new bank account
       /* BanckAccount account = new BanckAccount(
                "123456789",
                "John Doe",
                1000.0,
                500.0
        );*/
        System.out.println("Enter account number:");
        double accountNumber = sr.nextDouble();
        System.out.println("Enter account holder name:");
        String accountHolderName = sr.next();
        System.out.println("Enter initial balance:");
        double initialBalance = sr.nextDouble();

        BanckAccount account = new BanckAccount(accountHolderName,accountHolderName, initialBalance, 0.0);

        // Display account details
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Initial Balance: " + account.getBalance());

        // Consult balance
        double consultarSaldo =  sr.nextDouble();
        System.out.println("Saldo: " + account.ConsultarSaldo(account.getBalance()));

        // Deposit money
        account.deposit(200.0);
        System.out.println("Balance after deposit: " + account.getBalance());

        // Withdraw money
        account.withdraw(150.0);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}
