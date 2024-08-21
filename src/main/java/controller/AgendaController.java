package controller;

import model.Agendamento;
import model.Dono;
import model.Loja;
import model.Procedimento;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {
    private List<String> pets = new ArrayList<>(); // mudar depois para uma lista da classe Pet
    private Loja loja = new Loja();

    public List<String> atualizarCombo(String cpf){
        pets = loja.verificarCpf(cpf).getPets(); // verificarCpf retorna um dono, então pegamos a lista de pet desse dono

        return pets;
    }

    public Agendamento addAgendamento(Dono dono, String pet, List<Procedimento> procedimentos){
        Agendamento agendamento = new Agendamento(dono, pet, procedimentos);
        loja.getAgendamentos().add(agendamento);

        return agendamento;
    }
}
