package window;

import controller.AgendaController;
import model.Loja;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class AgendarWindow extends javax.swing.JFrame {
    private Loja loja = new Loja();
    private AgendaController agendaController = new AgendaController(loja);
    private Vector lista_pet;

    public AgendarWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Inicializar os componentes
        jPanel1 = new JPanel();
        jLabel1 = new JLabel("CPF");
        jTextField1 = new JTextField(15);
        jButton1 = new JButton("OK");

        jLabel2 = new JLabel("Pet");
        jComboBox1 = new JComboBox<>();
        try {
            jComboBox1.setModel(new DefaultComboBoxModel<>(lista_pet));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        jLabel4 = new JLabel("Nome do Dono");
        jTextField3 = new JTextField(15);

        buttonGroup = new ButtonGroup();
        jRadioButton1 = new JRadioButton("Cachorro");
        jRadioButton2 = new JRadioButton("Gato");
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);

        jLabel5 = new JLabel("Especie");
        jLabel6 = new JLabel("Procedimentos");

        jList1 = new JList<>(new String[]{"Cortar Unhas", "Banho", "Tosa"});
        jScrollPane1 = new JScrollPane(jList1);

        jButton2 = new JButton("Adicionar");
        jButton3 = new JButton("Concluir");

        // Configurar as ações dos botões
        jButton1.addActionListener(e -> {
            this.lista_pet = new Vector(agendaController.atualizarCombo(jTextField1.getText()));
            jComboBox1.setModel(new DefaultComboBoxModel<>(lista_pet));
        });

        jTextField3.addActionListener(evt -> jTextField3ActionPerformed(evt));

        // Definir layout principal como GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Adicionar os componentes ao layout
        c.gridx = 0;
        c.gridy = 0;
        add(jLabel1, c);

        c.gridx = 1;
        add(jTextField1, c);

        c.gridx = 2;
        add(jButton1, c);

        c.gridx = 0;
        c.gridy = 1;
        add(jLabel2, c);

        c.gridx = 1;
        add(jComboBox1, c);

        c.gridx = 0;
        c.gridy = 2;
        add(jLabel4, c);

        c.gridx = 1;
        add(jTextField3, c);

        c.gridx = 0;
        c.gridy = 3;
        add(jLabel5, c);

        c.gridx = 1;
        add(jRadioButton1, c);

        c.gridx = 1;
        c.gridy = 4;
        add(jRadioButton2, c);

        c.gridx = 0;
        c.gridy = 5;
        add(jLabel6, c);

        c.gridx = 1;
        c.gridheight = 2;
        add(jScrollPane1, c);

        c.gridy = 7;
        c.gridwidth = 1;
        add(jButton2, c);

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
}