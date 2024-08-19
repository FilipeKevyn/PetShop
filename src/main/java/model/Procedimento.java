package model;

public class Procedimento {
    // adicionar os metodos com os preços dos procedimentos
    private String nome;
    private int tempo; // em minutos
    private double preco;

    private Procedimento[] procedimentos = {
            new Procedimento("Cortar as unhas", 20, 30),
            new Procedimento("Tosa",30, 20),
            new Procedimento("Banho", 80, 50)
    }; // retirar

    public Procedimento(String nome, int tempo, double preco){
        this.nome = nome;
        this.tempo = tempo;
        this.preco = preco;
    }


    @Override
    public String toString() {
        return "[" + nome + "," + tempo + "," + preco + "]";
    }
}
