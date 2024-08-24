package window;

import model.Pet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TableTestWindow extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public TableTestWindow() {
        setTitle("Tabela de Donos e Pets");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel(new Object[]{"Nome", "CPF", "Pet"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Método para adicionar uma linha à tabela
    public void adicionarLinha(String nome, String cpf, Pet pet) {
        tableModel.addRow(new Object[]{nome, cpf, pet});
    }
}