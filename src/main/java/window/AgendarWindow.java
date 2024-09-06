package window;

import controller.AgendaController;
import controller.CadastroController;
import model.Pet;
import model.Procedimento;
import validators.CPFvalidator;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.List;

public class AgendarWindow extends JFrame {
    private String cpf;
    private String nomeDono;
    private Pet pet;
    private AgendaController agendaController = AgendaController.getInstance();
    private CPFvalidator cpfValidator;
    private List<Pet> lista_pet;
    private Pet[] pets;
    private Procedimento procedimento;

    public AgendarWindow() {
        initComponents();
        cpfValidator = new CPFvalidator(); // Inicialize o CPFvalidator
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Inicializar os componentes
        jPanel1 = new JPanel();
        cpfLabel = new JLabel("CPF");
        cpfTextfield = new JFormattedTextField();
        okButton = new JButton("OK");

        petLabel = new JLabel("Pet");
        jComboBox1 = new JComboBox<>();

        donoLabel = new JLabel("Nome do Dono");
        donoTextField = new JTextField(15);

        buttonGroup = new ButtonGroup();
        dogRadioButton = new JRadioButton("Cachorro");
        catRadioButton = new JRadioButton("Gato");
        buttonGroup.add(dogRadioButton);
        buttonGroup.add(catRadioButton);

        jLabel5 = new JLabel("Especie");
        jLabel6 = new JLabel("Procedimentos");

        jScrollPane1 = new JScrollPane();
        jListProced = new JList<>(agendaController.getLoja().getProcedimentos().toArray(new Procedimento[0]));
        jScrollPane1.setViewportView(jListProced);


        jButton3 = new JButton("Concluir");

        // Configurar as ações dos botões
        okButton.addActionListener(e -> {
            String cpf = cpfTextfield.getText(); // Capturar CPF aqui
            System.out.println("CPF informado: " + cpf);

            if (!cpfValidator.validar(cpf)) {
                JOptionPane.showMessageDialog(null, "Dono não encontrado", "CPF error", JOptionPane.ERROR_MESSAGE);
            } else {
                nomeDono = agendaController.getLoja().buscarDono(cpf).getNome();
                System.out.println("Nome do Dono encontrado: " + nomeDono);
                lista_pet = agendaController.atualizarCombo(cpf);

                if (nomeDono != null) {
                    donoTextField.setText(nomeDono);
                    pets = lista_pet.toArray(new Pet[0]);

                    // Limpa o JComboBox e adiciona a opção "Escolha o pet"
                    jComboBox1.removeAllItems();
                    jComboBox1.addItem(null);  // Ou "Escolha o pet"
                    for (Pet pet : pets) {
                        jComboBox1.addItem(pet);
                    }
                }
            }
        });

        jComboBox1.addActionListener(e -> {
            pet = (Pet) jComboBox1.getSelectedItem();
            if (pet != null) {
                if (pet.getEspecie().equals("Cachorro")) {
                    buttonGroup.setSelected(dogRadioButton.getModel(), true);
                } else {
                    buttonGroup.setSelected(catRadioButton.getModel(), true);
                }
            }
        });

        // Adicionando Agendamento
        adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(e -> {
            agendaController.addAgendamento(nomeDono, cpf, pet, jListProced.getSelectedValuesList());
        });

        donoTextField.addActionListener(evt -> jTextField3ActionPerformed(evt));

        // Definir layout principal como GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Adicionar os componentes ao layout
        c.gridx = 0;
        c.gridy = 0;
        add(cpfLabel, c);

        c.gridx = 1;
        MaskFormatter maskcpf = null;
        try {
            maskcpf = new MaskFormatter("###.###.###-##");
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        maskcpf.install(cpfTextfield);
        add(cpfTextfield, c);

        c.gridx = 2;
        add(okButton, c);

        c.gridx = 0;
        c.gridy = 1;
        add(petLabel, c);

        c.gridx = 1;
        add(jComboBox1, c);

        c.gridx = 0;
        c.gridy = 2;
        add(donoLabel, c);

        c.gridx = 1;
        add(donoTextField, c);

        c.gridx = 0;
        c.gridy = 3;
        add(jLabel5, c);

        c.gridx = 1;
        add(dogRadioButton, c);

        c.gridx = 1;
        c.gridy = 4;
        add(catRadioButton, c);

        c.gridx = 0;
        c.gridy = 5;
        add(jLabel6, c);

        c.gridx = 1;
        c.gridheight = 2;
        add(jScrollPane1, c);

        c.gridy = 7;
        c.gridwidth = 1;
        add(adicionarButton, c);

        c.gridx = 2;
        c.gridy = 7;
        add(jButton3, c);

        // Centralizar a janela na tela
        pack();
        setLocationRelativeTo(null);
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Adicionar ação
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AgendarWindow().setVisible(true));

        // Inicialização de cadastros para testes
        CadastroController cadastroController = CadastroController.getInstance();
        cadastroController.addCadastro("rapariga", "123.456.789-00");
        cadastroController.addPet("tomaz", "Cachorro");
        cadastroController.addPet("Bola", "Gato");

        cadastroController.addCadastro("corno manso", "321.654.987-00");
        cadastroController.addPet("toto", "Cachorro");
        cadastroController.addPet("tatu", "Gato");
    }

    public void mostrar() {
        new AgendarWindow().setVisible(true);
    }

    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton okButton;
    private javax.swing.JButton adicionarButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<Pet> jComboBox1;

    private javax.swing.JLabel cpfLabel;
    private javax.swing.JLabel petLabel;
    private javax.swing.JLabel donoLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private JList<Procedimento> jListProced;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton dogRadioButton;
    private javax.swing.JRadioButton catRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField cpfTextfield;
    private javax.swing.JTextField donoTextField;
}
