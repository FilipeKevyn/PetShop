package model;

public class Procedimento {
    // adicionar os metodos com os preços dos procedimentos
    private String nome;
    private int tempo; // em minutos
    private double preco;

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
