package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agendamento implements Serializable {
    private UUID id;
    private String nome_pet;
    private String dono;

    private List<Procedimento> procedimentos = new ArrayList<>();

    public Agendamento(Dono dono, Pet pet, List<Procedimento> procedimentos){
        id = UUID.randomUUID();
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    @Override
    public String toString() {
        return "Agendamento{" +
                "id=" + id +
                ", nome_pet='" + nome_pet + '\'' +
                ", dono='" + dono + '\'' +
                ", valor=" +
                '}';
    }
}
