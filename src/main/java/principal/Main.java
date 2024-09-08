package principal;

//import window.AgendarWindow;


import controller.AgendaController;
import controller.CadastroController;
import model.Dono;
import model.Loja;
import model.Procedimento;
import window.TabelaWindow;
import window.TelaInicial;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // adicionar os procedimentos a loja
        AgendaController agendaController = AgendaController.getInstance();
        agendaController.getLoja().addProcedimentos("Cortar as unhas",15,25);
        agendaController.getLoja().addProcedimentos("Banho",65,50);
        agendaController.getLoja().addProcedimentos("Tosa",70,60);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaInicial().setVisible(true));
    }
}
