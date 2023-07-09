package classes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Player extends Rectangle {
    public int playerSpeed = 4;
    public int direcao = 1;
    public boolean right;
    public boolean left;
    public boolean up;
    public boolean down;

    public int currAnimation = 0;
    public int currFrames = 0;
    public int targetFrames = 20;

    public static List<Bullet> municao = new ArrayList<Bullet>();
    public boolean shoot;

    public Player(int x, int y) {
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
            direcao = 1;
        } else if (left && !World.isColliding(x - playerSpeed, y)) {
            x -= playerSpeed;
            direcao = -1;
        }

        currFrames++;
        if (currFrames == targetFrames) {
            currFrames = 0;
            currAnimation++;
            if (currAnimation == 2) {
                currAnimation = 0;
            }
        }

        if (shoot) {
            shoot = false;
            municao.add(new Bullet(x, y, direcao));
        }

        for (int i = 0; i < municao.size(); i++) {
            municao.get(i).tick();
        }
    };

    public void render(Graphics graphicModule) {
        if (up) {
            graphicModule.drawImage(Spritesheet.playerUp[currAnimation], x, y, 32, 32, null);
        } else if (down) {
            graphicModule.drawImage(Spritesheet.playerDown[currAnimation], x, y, 32, 32, null);
        } else if (right) {
            graphicModule.drawImage(Spritesheet.playerRight[currAnimation], x, y, 32, 32, null);
        } else if (left) {
            graphicModule.drawImage(Spritesheet.playerLeft[currAnimation], x, y, 32, 32, null);
        } else {
            graphicModule.drawImage(Spritesheet.playerDown[0], x, y, 32, 32, null);
        }

        for (Bullet bullet : municao) {
            bullet.render(graphicModule);
        }
    }
}
