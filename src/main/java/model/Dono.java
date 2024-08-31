package model;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Dono {
    private String nome;

    private String cpf;
    private List<Pet> pets;

    public Dono(){
        this.pets = new ArrayList<>();
    }
    public Dono(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.pets = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Pet> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return nome;
    }
}
