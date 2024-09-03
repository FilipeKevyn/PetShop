package principal;

//import window.AgendarWindow;


import controller.AgendaController;
import model.Dono;
import model.Loja;
import model.Procedimento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //AgendarWindow petWindow = new AgendarWindow();
        Loja loja = Loja.getInstance();
        loja.addProcedimentos("Cortar unha", 20, 20);
        loja.addProcedimentos("Banho", 50, 60);
        loja.addProcedimentos("Tosa", 90, 50);

        List<Procedimento> procedimentos = new ArrayList<>();
        procedimentos.add(loja.getProcedimentos().get(1));
        procedimentos.add(loja.getProcedimentos().get(2));

        List<Procedimento> procedimentos2 = new ArrayList<>();
        procedimentos2.add(loja.getProcedimentos().get(1));
        procedimentos2.add(loja.getProcedimentos().get(2));

        //ArrayList<Procedimento> procedimentos = loja;
        AgendaController agendaController = new AgendaController();
        agendaController.addAgendamento("Filipe", "1234",
                "Dudu", "Cachorro", procedimentos);

        AgendaController agendaController2 = new AgendaController();
        agendaController2.addAgendamento("Beto", "321","Bixano","Gato",procedimentos2);

        System.out.println(loja.getAgendamentos());
    }
}
