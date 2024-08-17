package principal;

import model.Agendamento;
import model.Dono;
import model.Pet;
import model.Procedimento;
//import window.AgendarWindow;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //AgendarWindow petWindow = new AgendarWindow();
        Dono dono = new Dono("Dudu");
        Pet pet = new Pet("Xibiu", "Gato");
        int valor = 89;

        Agendamento agendamento = new Agendamento();
        agendamento.addAgenda(pet,dono,valor);
        System.out.println(agendamento.getAgenda_mtz());

    }
}
