import java.util.Locale;
import java.util.Scanner;

public class Desafio_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        int purchaseCount = scanner.nextInt();

        if (purchaseCount == 0) {
            System.out.println("Nenhuma compra registrada.");
        } else {
            double totalSpent = 0.0;

            for(int i = 0; i < purchaseCount; i++){
                double purchaseValue  = scanner.nextDouble();
                totalSpent += purchaseValue ;
            }

            double averagePurchase = totalSpent / purchaseCount;
            System.out.printf("%.2f%n", totalSpent);
            System.out.printf("%.2f%n",averagePurchase ); // TODO: Imprima a média
        }

        scanner.close();
    }
}
