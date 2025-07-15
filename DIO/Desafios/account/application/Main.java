package DIO.Desafios.account.application;

import DIO.Desafios.account.entities.BankAccount;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        // Create a new bank account
        System.out.println("Enter account number:");
        double accountNumber = sr.nextDouble();
        System.out.println("Enter account holder name:");
        String accountHolderName = sr.next();
        System.out.println("Enter initial balance:");
        double initialBalance = sr.nextDouble();

        BankAccount account = new BankAccount(accountHolderName,
                accountHolderName, initialBalance, 0.0);


        int opcao;
        do {
            System.out.println("\n--- Painel Bancário ---");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Ver limite especial");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sr.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Valor para depósito: ");
                    double valorDeposito = sr.nextDouble();
                    account.deposit(valorDeposito);
                    System.out.println("Depósito realizado.");
                    break;
                case 3:
                    System.out.print("Valor para saque: ");
                    double valorSaque = sr.nextDouble();
                    try {
                        account.withdraw(valorSaque);
                        System.out.println("Saque realizado.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Limite especial: " + account.getOverdraftLimit());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        sr.close();
    }
}
