import java.util.Scanner;

public class Desafio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de dados do usuário
        boolean hasPermission = scanner.nextBoolean();
        // Lê um valor booleano (true ou false)
        int age = scanner.nextInt(); // Lê a idade como inteiro
        if(hasPermission == true && age >= 18 ){
            System.out.println("Acesso permitido");
        }else if (hasPermission == true && age < 18) {
            System.out.println("Idade insuficeinte");
        } else {
            System.out.println("Acesso negado");
        }
        scanner.close();
    }
}
