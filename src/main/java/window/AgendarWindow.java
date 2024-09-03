package window;

import controller.AgendaController;
import validators.CPFvalidator;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.List;
import java.util.Vector;

public class AgendarWindow extends javax.swing.JFrame {
    private AgendaController agendaController = AgendaController.getInstance();
    private CPFvalidator cpfValidator;
    private Vector lista_pet;

    public AgendarWindow() {
        initComponents();
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
        try {
            jComboBox1.setModel(new DefaultComboBoxModel<>(lista_pet));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        donoLabel = new JLabel("Nome do Dono");
        donoTextField = new JTextField(15);

        buttonGroup = new ButtonGroup();
        dogRadioButton = new JRadioButton("Cachorro");
        catRadioButton = new JRadioButton("Gato");
        buttonGroup.add(dogRadioButton);
        buttonGroup.add(catRadioButton);

        jLabel5 = new JLabel("Especie");
        jLabel6 = new JLabel("Procedimentos");

        jList1 = new JList<>(new String[]{"Cortar Unhas", "Banho", "Tosa"});
        jScrollPane1 = new JScrollPane(jList1);



        adicionarButton = new JButton("Adicionar");
        adicionarButton.addActionListener(e -> {

        });
        jButton3 = new JButton("Concluir");

        // Configurar as ações dos botões
        okButton.addActionListener(e -> {
            if (!cpfValidator.validar(cpfTextfield.getText())){
                JOptionPane.showMessageDialog(null,"Dono não encontrado", "CPF error",JOptionPane.ERROR_MESSAGE);
            }
            else {
                // verifica o dono e retorna a lista de pet para o combo box
            }
//            this.lista_pet = new Vector(agendaController.atualizarCombo(cpfTextfield.getText()));
//            jComboBox1.setModel(new DefaultComboBoxModel<>(lista_pet));
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
        } catch (ParseException e){
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO: Adicionar ação
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new AgendarWindow().setVisible(true));
    }

    public void mostrar() {
        new AgendarWindow().setVisible(true);
    }

    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton okButton;
    private javax.swing.JButton adicionarButton;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JLabel petLabel;
    private javax.swing.JLabel donoLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton dogRadioButton;
    private javax.swing.JRadioButton catRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField cpfTextfield;
    private javax.swing.JTextField donoTextField;
}