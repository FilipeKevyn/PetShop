package window;

import javax.swing.*;
import java.awt.*;

public class AgendarWindow {
    private JFrame frame;
    public AgendarWindow() {
        // Criação do frame
        frame = new JFrame("Informacoes do Pet");

        frame.setSize(400, 300);

        // Criação do painel com GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Primeiro componente: Label "Espécie"
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel speciesLabel = new JLabel("Especie:");
        panel.add(speciesLabel, gbc);

        // Primeiro componente: ComboBox
        gbc.gridx = 1;
        gbc.gridy = 0;
        String[] speciesOptions = {"Cachorro", "Gato"};
        JComboBox<String> speciesComboBox = new JComboBox<>(speciesOptions);
        panel.add(speciesComboBox, gbc);

        // Segundo componente: Label "Nome do pet"
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel petNameLabel = new JLabel("Nome do pet:");
        panel.add(petNameLabel, gbc);

        // Segundo componente: Campo de texto para o nome do pet
        gbc.gridx = 1;
        gbc.gridy = 1;
        JTextField petNameField = new JTextField(15);
        panel.add(petNameField, gbc);

        // Terceiro componente: Label "Nome do dono"
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel ownerNameLabel = new JLabel("Nome do dono:");
        panel.add(ownerNameLabel, gbc);

        // Terceiro componente: Campo de texto para o nome do dono
        gbc.gridx = 1;
        gbc.gridy = 2;
        JTextField ownerNameField = new JTextField(15);
        panel.add(ownerNameField, gbc);

        // Quarto componente: JList com múltipla seleção
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Cortar as unhas");
        listModel.addElement("Tosa");
        listModel.addElement("Banho");
        JList<String> itemList = new JList<>(listModel);
        itemList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(itemList);
        panel.add(listScrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JButton btnAgendar = new JButton("Agendar");
        panel.add(btnAgendar, gbc);
        // Adiciona o painel ao frame e exibe a janela
        frame.add(panel);

        gbc.gridx = 2;
        gbc.gridy = 4;
        JButton btnAdicionar = new JButton("Adicionar");
        panel.add(btnAdicionar, gbc);
        // Adiciona o painel ao frame e exibe a janela
         frame.add(panel);
    }

    public void mostrar() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AgendarWindow a = new AgendarWindow();
        a.mostrar();
    }
}
