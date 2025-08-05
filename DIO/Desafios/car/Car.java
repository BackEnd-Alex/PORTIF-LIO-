package DIO.Desafios.car;

public class Car {
    //private Car carro;
    private boolean ligado;
    private double velocidade;
    private  int marcha;

    public Car(double velocidade, int marcha) {
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = 0;
    }
    public void estadoDoCarro() {
        if (!ligado) {
//            velocidade = 0;
//            marcha = 0;
            System.out.println("Carro está desligado.");
        } else {
            System.out.println("Carro não pode ser ligado, " +
                    "precisa esta parado e em ponto morto.");
        }
    }
    public void passarMarcha() {
        if(marcha == 0) {
            System.out.println("Carro está em ponto morto," +
                    " não é possível passar marcha.");
            return;
        }  if (marcha == 1 && velocidade >= 20.0) {
                marcha++;
            System.out.println("Carro está em primeira marcha." + velocidade);
        } else if (marcha == 2 && velocidade >= 20.0) {
            marcha++;
            System.out.println("Carro está em segunda marcha.");
        } else if (marcha == 3 && velocidade >= 40.0) {
            marcha++;
            System.out.println("Carro está em terceira marcha.");
        } else if (marcha == 4 && velocidade >= 60.0) {
            marcha++;
            System.out.println("Carro está em quarta marcha.");
        } else if (marcha == 5 && velocidade >= 80.0) {
            marcha++;
            System.out.println("Carro está em quinta marcha.");
        }
        if (marcha == 6 && velocidade > 80.0) {
            marcha++;
            System.out.println("Marcha: " + marcha);
        } else {
            System.out.println("Marcha máxima atingida.");
        }
    }
}
