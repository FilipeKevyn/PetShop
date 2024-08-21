package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Loja implements Serializable {
    private List<Agendamento> agendamentos;
    private List<Dono> proprietarios;
    private List<String> pets;
    private List<Procedimento> procedimentos;

    public Loja() {
        agendamentos = new ArrayList<>();
        proprietarios = new ArrayList<>();
        pets = new ArrayList<>();
        procedimentos = new ArrayList<>();
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public List<Dono> getProprietarios() {
        return proprietarios;
    }

    public List<String> getPets() {
        return pets;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }
    public Dono verificarCpf(String cpf){
        for(Dono dono : getProprietarios()){
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
