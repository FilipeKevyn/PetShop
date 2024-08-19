package window;

import model.Especie;
import model.Pet;
import window.JanelaGenerica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AgendarWindow extends JanelaGenerica {
        private DefaultListModel<Pet> listModel;
        private JList<Pet> petList;
        private JComboBox<String> tipoComboBox;
        private List<Pet> pets;

        public AgendarWindow() {
            super("Agendar Pet", 500, 400);
            pets = new ArrayList<>();
            listModel = new DefaultListModel<>();
            petList = new JList<>(listModel);
            configurar();
        }

        private void configurar() {
            tipoComboBox = new JComboBox<>(new String[] { "Todos", "Gato", "Cachorro" });
            JButton adicionarButton = new JButton("Adicionar");
            JTextField nomeField = new JTextField(20);

            tipoComboBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    atualizarLista();
                }
            });

            adicionarButton.addActionListener(e -> {
                String nome = nomeField.getText();
                String tipo = (String) tipoComboBox.getSelectedItem();
                if (!nome.isEmpty() && tipo != null) {
                    Pet pet;
                    pet = new Pet(nome, tipo);
                    pets.add(pet);
                    nomeField.setText("");
                    atualizarLista();
                }
            });

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JPanel topPanel = new JPanel();
            topPanel.add(new JLabel("Nome:"));
            topPanel.add(nomeField);
            topPanel.add(tipoComboBox);
            topPanel.add(adicionarButton);

            panel.add(topPanel, BorderLayout.NORTH);
            panel.add(new JScrollPane(petList), BorderLayout.CENTER);

            frame.add(panel);
            frame.pack();
        }

        private void atualizarLista() {
            listModel.clear();
            String tipoSelecionado = (String) tipoComboBox.getSelectedItem();
            for (Pet pet : pets) {
                if (tipoSelecionado.equals("Todos") || pet.getClass().getSimpleName().equals(tipoSelecionado)) {
                    listModel.addElement(pet);
                }
            }
        }
    }

