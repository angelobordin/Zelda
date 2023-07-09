package classes;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends Rectangle {
    public int playerSpeed = 4;
    public boolean right;
    public boolean left;
    public boolean up;
    public boolean down;

    public int currAnimation = 0;
    public int currFrames = 0;
    public int targetFrames = 20;

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
        } else if (left && !World.isColliding(x - playerSpeed, y)) {
            x -= playerSpeed;
        }

        currFrames++;
        if (currFrames == targetFrames) {
            currFrames = 0;
            currAnimation++;
            if (currAnimation == 2) {
                currAnimation = 0;
            }
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
    }
}
