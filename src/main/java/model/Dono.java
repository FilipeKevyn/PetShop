package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class Dono {

    /* Dono irá ser necessário para guardar as informações como o
    cpf, que será utilizado para hora do agendamento
    */

    private String nome;
    private String cpf;

    private ArrayList<Pet> pets; // Dono agora terá a lista com seus pets
    public Dono(){}
    public Dono(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return nome;
    }
}
