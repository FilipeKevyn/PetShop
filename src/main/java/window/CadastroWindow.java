package window;

import controller.CadastroController;
import validators.CPFvalidator;
import validators.NomeValidator;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class CadastroWindow extends JFrame {
    private String cpf;
    private JTextField nomeDonoField;
    private JFrame CadUs;
    private JFormattedTextField cpfField;
    private JTextField nomePetField;
    private JComboBox<String> especiePetComboBox;
    private JButton adicionarButton;
    private JButton concluirButton;
    private CPFvalidator cpfValidator = new CPFvalidator();
    private NomeValidator nomeValidator = new NomeValidator();
    private CadastroController cadastroController = CadastroController.getInstance();

    public CadastroWindow() {
        CadUs = new JFrame("Cadastro Dono");

        CadUs.setSize(400, 300);
        CadUs.setLocationRelativeTo(null);

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

        cpfField = new JFormattedTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        MaskFormatter maskCPF = null;
        try {
            maskCPF = new MaskFormatter("###.###.###-##");
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        maskCPF.install(cpfField);
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
            cpf = cpfField.getText();
            if (!cpfValidator.validar(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF inserido incorretamente", "CPF error", JOptionPane.ERROR_MESSAGE);
            }
            else if (cpfValidator.verificarSeExiste(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado", "CPF error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!nomeValidator.validar(nome_pet)) {
                // caso o nome for vazio ou inválido
                JOptionPane.showMessageDialog(null, "Adicione pelo menos um Pet", "Cadastro error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                cadastroController.addPet(nome_pet, especie);
                System.out.println(cadastroController.getDono().getPets());
                nomePetField.setText("");
            }
        });
        buttonPanel.add(adicionarButton);

        // Botão Concluir
        concluirButton = new JButton("Concluir");
        concluirButton.addActionListener(e -> {
            String nomeDono = nomeDonoField.getText();
            cpf = cpfField.getText();

            if (!cpfValidator.validar(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF inserido incorretamente", "Cadastro error", JOptionPane.ERROR_MESSAGE);
            }
            else if (cpfValidator.verificarSeExiste(cpf)) {
                JOptionPane.showMessageDialog(null, "CPF já cadastrado", "Cadastro error", JOptionPane.ERROR_MESSAGE);
            }
            else if (cadastroController.getDono().getPets().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Adicione pelo menos um Pet", "Cadastro error", JOptionPane.ERROR_MESSAGE);
            }
            else if (!nomeValidator.validar(nomeDono)) {
                JOptionPane.showMessageDialog(null, "Nome não inserido", "Cadastro error", JOptionPane.ERROR_MESSAGE);
            } else {
                cadastroController.addCadastro(nomeDono, cpf);
                nomeDonoField.setText("");
                cpfField.setText("");
                nomePetField.setText("");
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "CONCLUIDO", JOptionPane.DEFAULT_OPTION);
            }
        });
        buttonPanel.add(concluirButton);

        // Adicionando o painel de botões à janela
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        CadUs.add(buttonPanel, gbc);
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
