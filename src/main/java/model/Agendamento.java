package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Agendamento implements Serializable {
    private Pet pet;
    private Dono dono;
    private List<Procedimento> procedimentos;

    public Agendamento(Dono dono, Pet pet, List<Procedimento> procedimentos){
        this.dono = dono;
        this.pet = pet;
        this.procedimentos = procedimentos;
    }

    public Pet getPet() {
        return pet;
    }

    public Dono getDono() {
        return dono;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    @Override
    public String toString() {
        return String.format("[dono = %s; nome do pet = %s; especie = %s; procedimentos = null;]",dono.getNome(),pet.getNome(),pet.getEspecie());
    }
}
