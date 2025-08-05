package DIO.Desafios.car;

import java.util.Scanner;

public class MainCAr {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
//        Car carro = new Car();
        System.out.println("Digite a velocidade do carro: ");
        double velocidade = sr.nextDouble();
        System.out.println("Digite a marcha do carro: ");
        int marcha = sr.nextInt();
        Car carro = new Car(velocidade, marcha);
        carro.estadoDoCarro();
        carro.passarMarcha();

    }
}
