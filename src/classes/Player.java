package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
    public int playerSpeed = 4;
    public boolean right;
    public boolean left;
    public boolean up;
    public boolean down;

    public Player(int x, int y) {
        // Posição do player e tamanho do sprite
        super(x, y, 32, 32);
    }

    public void tick() {
        if (up && !World.isColliding(x, y - playerSpeed)) {
            y -= playerSpeed;
        } else if (down && !World.isColliding(x, y + playerSpeed)) {
            y += playerSpeed;
        }

        if (right && !World.isColliding(x + playerSpeed, y)) {
            x += playerSpeed;
        } else if (left && !World.isColliding(x - playerSpeed, y)) {
            x -= playerSpeed;
        }
    };

    public void render(Graphics graphicModule) {
        graphicModule.setColor(Color.blue);
        graphicModule.fillRect(x, y, width, height);
    }
}
