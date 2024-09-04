package window;

import model.Loja;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TelaInicial extends JFrame {

    private JButton jButton2;
    private JButton jButton3;  // Botão "CADASTRAR USUARIO"
    private JButton jButton4;  // Novo botão "ABRIR TABELA"
    private JPanel jPanel1;

    public TelaInicial() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();  // Inicializando o botão "CADASTRAR USUARIO"
        jButton4 = new JButton();  // Inicializando o novo botão "ABRIR TABELA"

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jButton2.setText("AGENDAR");
        jButton2.addActionListener(evt -> openAgendar());

        jButton3.setText("CADASTRAR USUARIO");
        jButton3.addActionListener(evt -> openCadastrarUsuario1());

        // Configurando o novo botão "ABRIR TABELA"
        jButton4.setText("ABRIR TABELA");
        jButton4.addActionListener(evt -> {
            openTabela();
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE) // Novo botão "ABRIR TABELA"
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE) // Botão "CADASTRAR USUARIO"
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)) // Botão "AGENDAR"
                                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE) // Botão "CADASTRAR USUARIO"
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE) // Botão "AGENDAR"
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE) // Novo botão "ABRIR TABELA"
                                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
