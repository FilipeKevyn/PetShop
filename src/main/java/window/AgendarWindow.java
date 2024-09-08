package window;

import controller.AgendaController;
import controller.CadastroController;
import model.Loja;
import model.Pet;
import model.Procedimento;
import validators.CPFvalidator;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.util.List;

public class AgendarWindow extends JFrame {
    private String nomeDono;
    private Pet pet;
    private String cpf;
    private AgendaController agendaController = AgendaController.getInstance();
    private Loja loja = agendaController.getLoja();
    private CPFvalidator cpfValidator;
    private List<Pet> lista_pet;
    private Pet[] pets;

    public AgendarWindow() {
        initComponents();
        cpfValidator = new CPFvalidator(); // Inicialize o CPFvalidator
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Inicializar os componentes
        jPanel1 = new JPanel();
        setTitle("Agendar Pet");

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
        jListProced = new JList<>(loja.getProcedimentos().toArray(new Procedimento[0]));
        jScrollPane1.setViewportView(jListProced);

        // Configurar as ações dos botões

        okButton.addActionListener(e -> {
            String cpf = cpfTextfield.getText(); // Capturar CPF aqui
            System.out.println("CPF informado: " + cpf);

            if (!cpfValidator.validar(cpf)) {
                JOptionPane.showMessageDialog(null, "Dono não encontrado", "CPF error", JOptionPane.ERROR_MESSAGE);
            } else {
                nomeDono = loja.buscarDono(cpf).getNome();
                System.out.println("Nome do Dono encontrado: " + nomeDono);
                lista_pet = agendaController.atualizarCombo(cpf);

                if (nomeDono != null) {
                    donoTextField.setText(nomeDono);
                    pets = lista_pet.toArray(new Pet[0]);

                    // Limpa o JComboBox e adiciona os pet mais um valor null
                    jComboBox1.removeAllItems();
                    jComboBox1.addItem(null);
                    for (Pet pet : pets) {
                        jComboBox1.addItem(pet);
                    }
                }
            }
        });

        jComboBox1.addActionListener(e -> {
            pet = (Pet) jComboBox1.getSelectedItem();

            // autocomplet do RadionButton
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
            if (pet == null){
                JOptionPane.showMessageDialog(null, "Pet não selecionado", "PET error", JOptionPane.ERROR_MESSAGE);
            }
            if (loja.verificarPet(pet)){
                JOptionPane.showMessageDialog(null, "Pet já agendado", "PET error", JOptionPane.ERROR_MESSAGE);
            }
            else if (jListProced.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Adicione pelo menos 1 procedimento", "Agendamento error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                agendaController.addAgendamento(nomeDono, cpf, pet, jListProced.getSelectedValuesList());
            }
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

        // Centralizar a janela na tela
        pack();
        setLocationRelativeTo(null);
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

    // componentes
    private ButtonGroup buttonGroup;
    private JButton okButton;
    private JButton adicionarButton;
    private JComboBox<Pet> jComboBox1;
    private JLabel cpfLabel;
    private JLabel petLabel;
    private JLabel donoLabel;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JList<Procedimento> jListProced;
    private JPanel jPanel1;
    private JRadioButton dogRadioButton;
    private JRadioButton catRadioButton;
    private JScrollPane jScrollPane1;
    private JFormattedTextField cpfTextfield;
    private JTextField donoTextField;
}
