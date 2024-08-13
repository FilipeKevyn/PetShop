package window;

import javax.swing.*;

public abstract class JanelaGenerica {
    protected JFrame frame;

    public JanelaGenerica(String titulo, int largura, int altura) {
        frame = new JFrame();
        frame.setSize(largura, altura);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(titulo);
        frame.setLocationRelativeTo(null);
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}
