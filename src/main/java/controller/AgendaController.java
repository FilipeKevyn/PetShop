package controller;

import model.*;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AgendaController{
    private Loja loja = CadastroController.getInstance().getLoja();
    private static AgendaController instance;
    private AgendaController(){}

    public static AgendaController getInstance() {
        if (instance == null){
            instance = new AgendaController();
        }
        return instance;
    }

    public Agendamento addAgendamento(String dono, String cpf, Pet pet, List<Procedimento> procedimentos){
        Dono donoPet = new Dono(dono, cpf);
        Agendamento agendamento = new Agendamento(donoPet, pet, procedimentos);

        // se não for o primeiro agendamento, irá mudar o tempo
        if (loja.getAgendamentos().indexOf(agendamento) != 0){
            setTempo(agendamento);
        }
        loja.getAgendamentos().add(agendamento);
        return agendamento;
    }

    public List<Pet> atualizarCombo(String cpf){
        List<Pet> pets = loja.buscarDono(cpf).getPets(); // verificarCpf retorna um dono, então pegamos a lista de pet desse dono

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

    public Loja getLoja() {
        return loja;
    }
}
