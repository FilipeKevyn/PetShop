package window;

import controller.CadastroController;

import javax.swing.*;
import java.awt.*;

public class CadastroDonoPet extends JFrame {
    private JTextField nomeDonoField;
    private JTextField cpfField;
    private JTextField nomePetField;
    private JComboBox<String> especiePetComboBox;
    private JButton adicionarButton;
    private JButton concluirButton;
    private JButton jButton1;

    private TableTestWindow tableTestWindow;
    private CadastroController cadastroController;

    public CadastroDonoPet() {
        setTitle("Cadastro Dono");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableTestWindow = new TableTestWindow();
        cadastroController = new CadastroController(tableTestWindow);

        // Configurando layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        jButton1 = new JButton("Tabela");
        jButton1.addActionListener(evt -> openTable());
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(jButton1, gbc);

        // Nome do Dono
        JLabel nomeDonoLabel = new JLabel("Nome do Dono");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(nomeDonoLabel, gbc);

        nomeDonoField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nomeDonoField, gbc);

        // CPF
        JLabel cpfLabel = new JLabel("Cpf");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(cpfLabel, gbc);

        cpfField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(cpfField, gbc);

        // Nome do Pet
        JLabel nomePetLabel = new JLabel("Nome do Pet");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(nomePetLabel, gbc);

        nomePetField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(nomePetField, gbc);

        // Espécie do Pet
        JLabel especiePetLabel = new JLabel("Espécie do Pet");
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(especiePetLabel, gbc);

        especiePetComboBox = new JComboBox<>(new String[]{"Cachorro", "Gato"});
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(especiePetComboBox, gbc);

        // Botão Adicionar
        adicionarButton = new JButton("Adicionar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        adicionarButton.addActionListener(e -> {
            String nomePet = nomePetField.getText();
            cadastroController.addPet(nomePet);
        });
        add(adicionarButton, gbc);

        // Botão Concluir
        concluirButton = new JButton("Concluir");
        gbc.gridx = 1;
        gbc.gridy = 4;
        concluirButton.addActionListener(e -> {
            String nomeDono = nomeDonoField.getText();
            String cpf = cpfField.getText();
            cadastroController.addCadastro(nomeDono, cpf);
        });
        add(concluirButton, gbc);
    }

    public void openTable() {
        tableTestWindow.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroDonoPet tela = new CadastroDonoPet();
            tela.setVisible(true);
        });
    }
}