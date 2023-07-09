package classes;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle {
    public int direcao = 1;
    public int speed = 8;
    public int frames = 0;

    public Bullet(int x, int y, int dir) {
        super(x + 32, y, 32, 32);
        this.direcao = dir;
    }

    public void tick() {
        x += speed * direcao;
        frames++;
        if (frames == 120) {
            Player.municao.remove(this);
            return;
        }
    }

    public void render(Graphics graphicModule) {
        graphicModule.drawImage(Spritesheet.arrow, x, y, width, height, null);
    }
}
