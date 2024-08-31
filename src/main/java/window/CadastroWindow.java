package window;

import controller.CadastroController;

import javax.swing.*;
import java.awt.*;

public class CadastroWindow {

    private JTextField nomeDonoField;
    private JFrame CadUs;
    private JTextField cpfField;
    private JTextField nomePetField;
    private JComboBox<String> especiePetComboBox;
    private JButton adicionarButton;
    private JButton concluirButton;
    private JButton jButton1;

    private TableTestWindow tableTestWindow;
    private CadastroController cadastroController;

    public CadastroWindow() {
        CadUs = new JFrame("Cadastro Dono");

        CadUs.setSize(400, 300);
        CadUs.setLocationRelativeTo(null);

        tableTestWindow = new TableTestWindow();
        cadastroController = new CadastroController(tableTestWindow);

        // Configurando layout
        CadUs.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);  // Espaçamento entre os componentes

        // Nome do Dono
        JLabel nomeDonoLabel = new JLabel("Nome do Dono:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        CadUs.add(nomeDonoLabel, gbc);

        nomeDonoField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        CadUs.add(nomeDonoField, gbc);

        // CPF
        JLabel cpfLabel = new JLabel("CPF:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        CadUs.add(cpfLabel, gbc);

        cpfField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        CadUs.add(cpfField, gbc);

        // Nome do Pet
        JLabel nomePetLabel = new JLabel("Nome do Pet:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        CadUs.add(nomePetLabel, gbc);

        nomePetField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        CadUs.add(nomePetField, gbc);

        // Espécie do Pet
        JLabel especiePetLabel = new JLabel("Especie do Pet:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        CadUs.add(especiePetLabel, gbc);

        especiePetComboBox = new JComboBox<>(new String[]{"Cachorro", "Gato"});
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        CadUs.add(especiePetComboBox, gbc);

        // Painel para os botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        // Botão Adicionar
        adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(e -> {
            String nome_pet = nomePetField.getText();
            String especie = especiePetComboBox.getSelectedItem().toString();
            cadastroController.addPet(nome_pet,especie);
            System.out.println(cadastroController.getDono().getPets());
            nomePetField.setText("");
        });
        buttonPanel.add(adicionarButton);

        // Botão Concluir
        concluirButton = new JButton("Concluir");
        concluirButton.addActionListener(e -> {
            String nomeDono = nomeDonoField.getText();
            String cpf = cpfField.getText();
            cadastroController.addCadastro(nomeDono, cpf);
            nomeDonoField.setText("");
            cpfField.setText("");
            nomePetField.setText("");
        });
        buttonPanel.add(concluirButton);

        // Botão Tabela
        jButton1 = new JButton("Tabela");
        jButton1.addActionListener(evt -> openTable());
        buttonPanel.add(jButton1);

        // Adicionando o painel de botões à janela
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        CadUs.add(buttonPanel, gbc);
    }

    public void openTable() {
        tableTestWindow.setVisible(true);
    }

    public void mostrar() {
        CadUs.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroWindow tela = new CadastroWindow();
            tela.mostrar();
        });
    }


}
