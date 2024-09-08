package model;


import java.time.LocalDateTime;

public class Procedimento {
    private String nome;
    private long tempo;
    private double preco;
    public Procedimento(String nome, long tempo, double preco){
        this.nome = nome;
        this.tempo = tempo;
        this.preco = preco;
    }

    public long getTempo() {
        return tempo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return nome + " R$ " + preco;
    }
}
