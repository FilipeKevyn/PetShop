package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Loja implements Serializable {
    private List<Agendamento> agendamentos;
    private List<Dono> cadastrados;
    private List<Pet> pets;
    private List<Procedimento> procedimentos;

    public Loja() {
        agendamentos = new ArrayList<>();
        cadastrados = new ArrayList<>();
        pets = new ArrayList<>();
        procedimentos = new ArrayList<>();
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public List<Dono> getCadastrados() {
return cadastrados;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }
    public Dono verificarCpf(String cpf){
        for(Dono dono : getCadastrados()){
            if (cpf == null){
                return null;
            }
            if (dono.getCpf().equals(cpf)){
                return dono;
            }
        }
        return null;
    }
}
