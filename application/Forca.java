package application;

import util.Jogador;
import util.JogoDaForca;

import java.util.Scanner;

public class Forca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Jogo da Forca ===");
        System.out.println("Digite o seu nome: ");
        Jogador jogador = new Jogador(sc.nextLine());

        System.out.println("Digite a palavra secreta (sem acento)");
        String palavra = sc.nextLine();
        limparTela();
        JogoDaForca jogo = new JogoDaForca(palavra);
        while (!jogo.ganhou() && !jogo.perdeu()){
            jogo.mostrarPalavras();
            jogo.mostrarLetrasErradas();
            System.out.println("Digite uma letra: ");
            char tentativas = sc.next().charAt(0);
            if (jogo.tentarLetra(tentativas)){
                System.out.println("Boa! A letra está na palavra.");
            } else{
                System.out.println("Errado! A letra nã está na palavra.");
            }
            System.out.println();
        }
        if (jogo.ganhou()){
            System.out.println("Parabéns " + jogador.getNome() + "! Você venceu! ");
        } else{
            System.out.println("Você perdeu! A Palavra era: " + palavra);
        }
        sc.close();
    }
    public  static  void limparTela(){
        for (int i = 0; i < 50; i++){
            System.out.println();
        }
    }
}