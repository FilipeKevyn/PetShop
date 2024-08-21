package model;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Dono {
    /* Dono irá ser necessário para guardar as informações como o
    cpf, que será utilizado para hora do agendamento
    */

    private String nome;

    private String cpf;
    private List<String> pets; // Dono agora terá a lista com seus pets

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

    public List<String> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return nome;
    }
}
