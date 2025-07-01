package DIO;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        System.out.println("Difina os lados do quadrado:");
        double lado1 = sr.nextDouble();
        double lado2 = sr.nextDouble();
        double area = lado1 * lado2;
        System.out.printf("Area do Quadrado: %.2f" , area);
    }
}
