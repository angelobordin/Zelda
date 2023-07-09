package classes;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {
    public static int windowWidth = 1024;
    public static int windowHeight = 768;
    public Player player;

    public Game() {
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        player = new Player(5, 5);
    };

    public void tick() {
        player.tick();
    };

    public void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics graphicModule = bufferStrategy.getDrawGraphics();
        graphicModule.setColor(Color.black);
        graphicModule.fillRect(0, 0, windowWidth, windowHeight);
        player.render(graphicModule);

        bufferStrategy.show();
    };

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
    };

    @Override
    public void run() {
        try {
            while (true) {
                tick();
                render();
                Thread.sleep(1000 / 60);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                player.right = true;
                break;
            case KeyEvent.VK_LEFT:
                player.left = true;
                break;
            case KeyEvent.VK_UP:
                player.up = true;
                break;
            case KeyEvent.VK_DOWN:
                player.down = true;
                break;
        }
    };

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                player.right = false;
                break;
            case KeyEvent.VK_LEFT:
                player.left = false;
                break;
            case KeyEvent.VK_UP:
                player.up = false;
                break;
            case KeyEvent.VK_DOWN:
                player.down = false;
                break;
        }
    };

    @Override
    public void keyTyped(KeyEvent e) {
    };
}
