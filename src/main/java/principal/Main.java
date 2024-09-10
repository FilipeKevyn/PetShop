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
        // Nome do arquivo para serialização
        String filename = "loja.ser";

        // Tentando desserializar a loja se o arquivo existir
        Loja loja = SerializationUtil.desserializarLoja(filename);

        AgendaController agendaController = AgendaController.getInstance();

        // Se a loja for null, isso significa que o arquivo não existe ou falhou na desserialização
        if (loja == null) {
            // Criar uma nova loja e adicionar procedimentos
            loja = CadastroController.getInstance().getLoja();
            loja.addProcedimentos("Cortar as unhas", 13, 35);
            loja.addProcedimentos("Banho", 65, 60);
            loja.addProcedimentos("Tosa", 60, 45);
            SerializationUtil.serializarLoja(loja,filename);
        }
        else {
            agendaController.setLoja(loja);
        }

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new TelaInicial().setVisible(true));
    }
}
