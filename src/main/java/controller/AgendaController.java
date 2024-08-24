package controller;

import model.*;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {
    private List<Pet> pets = new ArrayList<>();
    private Loja loja = new Loja();

    public List<Pet> atualizarCombo(String cpf){
        pets = loja.verificarCpf(cpf).getPets(); // verificarCpf retorna um dono, então pegamos a lista de pet desse dono

        return pets;
    }

    public Agendamento addAgendamento(Dono dono, Pet pet, List<Procedimento> procedimentos){
        Agendamento agendamento = new Agendamento(dono, pet, procedimentos);
        loja.getAgendamentos().add(agendamento);

        return agendamento;
    }
}
