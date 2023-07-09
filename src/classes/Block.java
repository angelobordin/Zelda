package classes;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {

    public Block(int x, int y) {
        // Posição do bloco e tamanho do sprite
        super(x, y, 32, 32);
    };

    public void render(Graphics graphicModule) {
        graphicModule.setColor(Color.gray);
        graphicModule.fillRect(x, y, width, height);
        graphicModule.setColor(Color.black);
        graphicModule.drawRect(x, y, width, height);
    }
}
