import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {
    public static int windowWidth = 1024;
    public static int windowHeight = 768; 

    public Game () {
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
    }

    public static void main(String[] args) {
        Game zelda = new Game();
        JFrame window = new JFrame();

        window.add(zelda);
        window.setTitle("Zelda");
        window.pack();
        window.setLocationRelativeTo(null);

        // Definindo para quando fechar a janela o processo deve ser encerrado!!
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setVisible(true);

        new Thread(zelda).start();
    }

    @Override
    public void run() {
        System.out.println("Jogando iniciado");
    }
}
