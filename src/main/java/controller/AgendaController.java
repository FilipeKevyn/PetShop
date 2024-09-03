package controller;

import model.*;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AgendaController{
    private List<Pet> pets = new ArrayList<>();
    private Loja loja = Loja.getInstance();
    public AgendaController(){
    }

    public Agendamento addAgendamento(String dono, String cpf, String nome_pet, String especie, List<Procedimento> procedimentos){
        Dono donoPet = new Dono(dono, cpf);
        Pet pet = new Pet(nome_pet, especie);
        Agendamento agendamento = new Agendamento(donoPet, pet, procedimentos);

        // se não for o primeiro agendamento, irá mudar o tempo
        if (loja.getAgendamentos().indexOf(agendamento) != 0){
            setTempo(agendamento);
        }
        loja.getAgendamentos().add(agendamento);

        return agendamento;
    }

    public List<Pet> atualizarCombo(String cpf){
        pets = loja.verificarCpf(cpf).getPets(); // verificarCpf retorna um dono, então pegamos a lista de pet desse dono

        return pets;
    }

    // soma o tempo de uma lista de procedimentos em um agendamento
    public long somarTempo(Agendamento agendamento){
        long tempo_somado = 0;
        for (Procedimento procedimento : agendamento.getProcedimentos()){
            tempo_somado += procedimento.getTempo();
        }

        return tempo_somado;
    }

    // soma todos os minutos dos agendamentos existentes
    public long tempoFinal(){
        long tempo = 0;
        for (Agendamento agendamento : loja.getAgendamentos()){
            tempo += somarTempo(agendamento);
        }
        return tempo;
    }

    public void setTempo(Agendamento agendamento){
        long minutofinal = tempoFinal();
        LocalDateTime tempofinal = agendamento.getDateTime().plusMinutes(minutofinal);

        agendamento.setDateTime(tempofinal);
    }
}
