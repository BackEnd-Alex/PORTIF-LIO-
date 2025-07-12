package DIO.Desafios;

import java.util.Scanner;

public class DesafioJava {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Entrada: ");
        System.out.print("Valor do Sálario: ");
        double salarioBruto = sr.nextDouble();
        System.out.print("Valor do Beneficio:");
        double valorBeneficio = sr.nextDouble();

        double imposto = 0;

        if(salarioBruto >= 0.0 && salarioBruto <= 1100){
           imposto = 0.05 * salarioBruto;
        } else if (salarioBruto > 1100 && salarioBruto <= 2500) {
            imposto = 0.10 * salarioBruto;
        } else {
            imposto = 0.15 * salarioBruto;
        }
        double salarioLiquido = salarioBruto - imposto + valorBeneficio;
        System.out.printf("Saída: %.2f", salarioLiquido);
    }
}
