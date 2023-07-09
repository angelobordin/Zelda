package classes;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {

    public Block(int x, int y) {
        // Posição do bloco e tamanho do sprite
        super(x, y, 32, 32);
    };

    public void render(Graphics graphicModule) {
        graphicModule.drawImage(Spritesheet.borderWall, x, y, 32, 32, null);
    }
}
