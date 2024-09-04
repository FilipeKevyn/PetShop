package model;


import java.time.LocalDateTime;

public class Procedimento {
    // adicionar os metodos com os preços dos procedimentos
    private String nome;
    private long tempo; // em minutos
    private double preco;
    public Procedimento(String nome, long tempo, double preco){
        this.nome = nome;
        this.tempo = tempo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTempo() {
        return tempo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " R$ " + preco;
    }
}
