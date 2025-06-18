package entities;

public class Product {
    private String nome;
    private double price;
    private int quantidadeEmEstoque;
    private int codigo;

    public Product(){

    }
    public Product(String nome, double price, int quantidadeEmEstoque, int codigo) {
        this.nome = nome;
        this.price = price;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void adicionaEstoque(int quantidade){
        if (quantidade > 0){
            quantidadeEmEstoque += quantidade;
            System.out.println(quantidade + "unidade de " + nome + "adicionadas.");
        } else {
            System.out.println("A quantidade a ser adicionada deve ser positiva.");
        }
    }
    public void removerEstoque(int quantidade){
        if(quantidade > 0 && this.quantidadeEmEstoque >= quantidade){
            this.quantidadeEmEstoque -= quantidade;
            System.out.println(quantidade + "unidades de" + nome + "removidas do estoque.");

        } else if(quantidade <= 0){
            System.out.println("A quantidade a ser removida deve ser positiva.");
        } else {
            System.out.println("Estoque insuficiente para remover" + quantidade);
        }
    }
    public double calcularValorTotal(){
        return price * quantidadeEmEstoque;
    }
}
