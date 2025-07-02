package DIO.Desafios;

import java.util.Scanner;

public class OrderProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       /* double itemValue = scanner.nextDouble();
        double shipping = scanner.nextDouble();
        boolean firstPurchase =  scanner.nextBoolean();

        double discount = 0.0;
        if(firstPurchase == true){
            discount = itemValue * 0.05;
        }
        double discountedValue = itemValue - discount;
        if (itemValue >= 200.0) {
            shipping =+ 0;
        }
        double finalValue = discountedValue + shipping;
        System.out.println(String.format("%.2f", finalValue));*/
        double itemsValue = scanner.nextDouble();
        double shipping = scanner.nextDouble();
        boolean firstPurchase = scanner.nextBoolean();

        double discount = 0.0;

        if (firstPurchase == true) {
            discount = itemsValue * 0.05;
        }

        double discountedValue = itemsValue - discount;

        if (itemsValue >= 200.0) {
            shipping =+ 0;
        }

        double finalValue = discountedValue + shipping;

        System.out.println(String.format("%.2f", finalValue));

        scanner.close();

    }
}
