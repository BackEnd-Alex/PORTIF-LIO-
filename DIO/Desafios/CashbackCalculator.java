package DIO.Desafios;

import java.util.Scanner;

public class CashbackCalculator {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            double productsValue = scan.nextDouble();
            scan.nextLine();
            String couponCode = scan.nextLine();

            double discount = 0;
            double cashback = 0;

            if (couponCode.equals("DESC10")) {
                discount = productsValue * 0.10;
            }

            double discountedValue = productsValue - discount;

            if (discountedValue >= 150.00)
                cashback = 15.0;

            double finalValue = discountedValue - cashback;

            System.out.printf("Valor final: R$ %.2f | Cashback: R$ %.2f\n", finalValue, cashback);

            scan.close();
        }

    }
