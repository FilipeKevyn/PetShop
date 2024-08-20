package controller;

import model.*;

import java.util.List;

public class Controlador {
    private Loja loja = new Loja();

    // A
    public Dono addDono(String nome, String cpf) {
        Dono dono = new Dono(nome,cpf);
        loja.getProprietarios().add(dono);

        return dono;
    }

    public Pet addPet(String nome, String especie){
        Pet pet = new Pet(nome, especie);
        loja.getPets().add(pet);

        return  pet;
    }

    public Procedimento addProcedimento(String nome, int tempo, double preco){
       Procedimento procedimento = new Procedimento(nome,tempo, preco);
       loja.getProcedimentos().add(procedimento);

       return procedimento;
    }

    // A
    public Agendamento addAgendamento(Dono dono, Pet pet, List<Procedimento> procedimentos) {
        Agendamento agendamento = new Agendamento(dono, pet, procedimentos);
        loja.getAgendamentos().add(agendamento);

        return agendamento;
    }
}
