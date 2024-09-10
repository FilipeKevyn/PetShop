package model;

import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Loja implements Serializable {
    private List<Agendamento> agendamentos;
    private List<Dono> cadastrados;
    private List<Procedimento> procedimentos;

    public Loja() {
        agendamentos = new ArrayList<>();
        cadastrados = new ArrayList<>();
        procedimentos = new ArrayList<>();
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public DefaultTableModel getAgendamentoModel() {
        Object[][] dados = new Object[agendamentos.size()][6];
        for (int i = 0; i < agendamentos.size(); i++) {
            Agendamento a = agendamentos.get(i);
            dados[i] = new Object[] {
                    a.getDono().getNome(),
                    a.getPet().getNome(),
                    a.getPet().getEspecie(),
                    a.getDateTime().format(DateTimeFormatter.ofPattern("kk:mm")),
                    a.qtdProcedimento(),
                    a.valorTotal(),
                    };

        }

        DefaultTableModel tableModel = new DefaultTableModel(dados,
             new String[]{
                    "Dono", "Nome do Pet", "Especie", "Horario", "Procedimento", "Valor",
            });

        return tableModel;
    }

    public List<Dono> getCadastrados() {
        return cadastrados;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public void addProcedimentos(String nome, long tempo, double preco) {
        Procedimento procedimento = new Procedimento(nome, tempo, preco);
        procedimentos.add(procedimento);
    }

    public Dono buscarDono(String cpf) {
        Dono dono = cadastrados.stream().filter(e -> e.getCpf().equals(cpf)).findFirst().orElse(null);
        return dono;
    }
    public boolean verificarPet(Pet pet){
        return agendamentos.stream().anyMatch(e -> e.getPet().equals(pet));
    }
}
