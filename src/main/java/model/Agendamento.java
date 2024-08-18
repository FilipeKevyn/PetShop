package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agendamento {
    private UUID id;

    private List<Object> agenda = new ArrayList<>();

    public List<Object> getAgenda_mtz() {
        return agenda_mtz;
    }

    private List<Object> agenda_mtz = new ArrayList<>();

    private String nome_pet;
    private String dono;
    int valor;
    public Agendamento(){

    }
    public List<Object> getAgenda() {
        return agenda;
    }

    public void addAgenda(Pet pet, Dono dono, int valor){
        agenda.add(pet.getNome());
        agenda.add(dono.getNome());
        agenda.add(pet.getEspecie());
        agenda.add(valor);
        agenda_mtz.add(agenda);
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", nome_pet='" + nome_pet + '\'' +
                ", dono='" + dono + '\'' +
                ", valor=" + valor +
                '}';
    }
}
