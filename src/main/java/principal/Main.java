package principal;

//import window.AgendarWindow;


import controller.AgendaController;
import controller.CadastroController;
import model.Dono;
import model.Loja;
import model.Procedimento;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //AgendarWindow petWindow = new AgendarWindow();

        //teste cadastro
        CadastroController cadastroController = CadastroController.getInstance();
        cadastroController.addCadastro("Filipe","1234");
        cadastroController.addCadastro("Beto","1234");
        //teste agendamento
        Loja loja = Loja.getInstance();
        AgendaController agendaController = AgendaController.getInstance();


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
        agendaController.addAgendamento("Filipe", "1234",
                "Dudu", "Cachorro", procedimentos);
        agendaController.addAgendamento("Beto", "321","Bixano","Gato",procedimentos2);

        System.out.println(loja.getAgendamentos());
        System.out.println(loja.getCadastrados());
    }
}
