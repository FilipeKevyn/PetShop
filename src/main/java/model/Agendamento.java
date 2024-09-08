package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Agendamento implements Serializable {
    private Pet pet;
    private Dono dono;
    private List<Procedimento> procedimentos;
    private LocalDateTime dateTime;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("kk:mm");

    public Agendamento(Dono dono, Pet pet, List<Procedimento> procedimentos){
        this.dono = dono;
        this.pet = pet;
        this.procedimentos = procedimentos;
        dateTime = LocalDateTime.now();
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double valorTotal(){
        return procedimentos.stream().mapToDouble(Procedimento::getPreco).sum();
    }
    public long qtdProcedimento(){
        return procedimentos.stream().count();
    }

    @Override
    public String toString() {
        return String.format("{dono = %s; nome do pet = %s; especie = %s; horário = %s; Qtd. Procedimentos %s; Valor: %s}",
            dono.getNome(),
            pet.getNome(),
            pet.getEspecie(),
            getDateTime().format(dtf),
            qtdProcedimento(),
            valorTotal());
    }
}
