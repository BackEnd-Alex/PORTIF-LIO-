package util;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class JogoDaForca {
    private String palavraSecreta;
    private Set<Character> letrasCertas;
    //Set<Character> representa uma coleção que não permite elementos repetitivos.
    private Set<Character> letrasErradas;
    private int tentativasRestantes;

    public JogoDaForca(String palavraSecreta) {

        this.palavraSecreta = palavraSecreta.toLowerCase();
        this.letrasCertas = new HashSet<>();
        this.letrasErradas =new HashSet<>();
        this.tentativasRestantes = tentativasRestantes = 6; // definimos a quant. de tentativas dentro do construtor.
    }
    public  boolean tentarLetra( char letra){
        letra = Character.toLowerCase(letra);
        if (palavraSecreta.indexOf(letra) >= 0){
            letrasCertas.add(letra);
            return true;
        } else{
            letrasErradas.add(letra);
            tentativasRestantes--;
            return false;
        }
    }
    public  boolean ganhou(){
        for (char c : palavraSecreta.toCharArray()) {
            if (!letrasCertas.contains(c))
                return false;
        }
        return true;

    }
    public  boolean perdeu(){
        return  tentativasRestantes <= 0;

    }
    public  void mostrarPalavras(){
        for (char c : palavraSecreta.toCharArray()){
            if (letrasCertas.contains(c)){
                System.out.print(c + " ");
            } else{
                System.out.println("__");
            }
        }
        System.out.println();
    }
    public void mostrarLetrasErradas(){
        System.out.println("Letras errdas: " + letrasErradas);
        System.out.println("Tentativas Restantes: " + tentativasRestantes);
    }
}
