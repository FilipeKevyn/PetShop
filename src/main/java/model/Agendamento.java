package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agendamento implements Serializable {
    private UUID id;

    private String nome_pet;

    private Dono dono;
    private List<Procedimento> procedimentos;

    public Agendamento(Dono dono, String pet, List<Procedimento> procedimentos){
        id = UUID.randomUUID();
        this.dono = dono;
        this.nome_pet = pet;
        this.procedimentos = procedimentos;
    }

    public String getNome_pet() {
        return nome_pet;
    }

    public Dono getDono() {
        return dono;
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
