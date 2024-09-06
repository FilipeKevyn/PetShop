package window;

import graphics.RoundedButton;
import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

    private RoundedButton jButton2;
    private RoundedButton jButton3;  // Botão "CADASTRAR USUARIO"
    private RoundedButton jButton4;  // Novo botão "ABRIR TABELA"
    private JPanel jPanel1;

    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jButton2 = new RoundedButton("AGENDAR");
        jButton3 = new RoundedButton("CADASTRAR USUARIO");
        jButton4 = new RoundedButton("ABRIR TABELA");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");

        // Configura o tamanho dos botões
        Dimension buttonSize = new Dimension(250, 35); // Ajusta o tamanho dos botões
        jButton2.setPreferredSize(buttonSize);
        jButton3.setPreferredSize(buttonSize);
        jButton4.setPreferredSize(buttonSize);

        // Adiciona ação aos botões
        jButton2.addActionListener(evt -> openAgendar());
        jButton3.addActionListener(evt -> openCadastrarUsuario1());
        jButton4.addActionListener(evt -> openTabela());

        // Configura o painel
        jPanel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adiciona margem ao painel
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20) // Espaçamento horizontal
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(20) // Espaçamento horizontal
                        )
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createSequentialGroup()
                        .addGap(40) // Espaçamento vertical inicial
                        .addComponent(jButton3)
                        .addGap(20) // Espaçamento vertical entre botões
                        .addComponent(jButton2)
                        .addGap(20) // Espaçamento vertical entre botões
                        .addComponent(jButton4)
                        .addGap(40) // Espaçamento vertical inferior
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    private void openAgendar() {
        AgendarWindow telaAgendar = new AgendarWindow();
        telaAgendar.mostrar();
    }

    private void openCadastrarUsuario1() {
        CadastroWindow cadastroDono = new CadastroWindow();
        cadastroDono.mostrar();
    }

    private void openTabela() {
        TabelaWindow tabelaWindow = new TabelaWindow();
        tabelaWindow.mostrar();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInicial().setVisible(true));
    }

}