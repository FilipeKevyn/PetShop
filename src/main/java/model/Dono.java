package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class Dono {
    // Criar uma nova forma de guardar informações do usuario
    private String nome;

    // private ArrayList<Pet> pets;
        // Dono não precisa de uma Lista de Pet
        // o pet do dono irá ser veinculado ao id do agendamento

    public Dono(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
