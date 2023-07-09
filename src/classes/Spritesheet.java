package classes;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
    public static BufferedImage spritesheet;
    public static BufferedImage borderWall;
    public static BufferedImage[] playerDown;
    public static BufferedImage[] playerUp;
    public static BufferedImage[] playerRight;
    public static BufferedImage[] playerLeft;

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(new FileInputStream("res/spritesheet.png"));
            playerDown = new BufferedImage[2];
            playerDown[0] = Spritesheet.getSprite(0, 11, 16, 16);
            playerDown[1] = Spritesheet.getSprite(16, 11, 16, 16);

            playerUp = new BufferedImage[2];
            playerUp[0] = Spritesheet.getSprite(68, 11, 16, 16);
            playerUp[1] = Spritesheet.getSprite(85, 11, 16, 16);

            playerRight = new BufferedImage[2];
            playerRight[0] = Spritesheet.getSprite(34, 11, 16, 16);
            playerRight[1] = Spritesheet.getSprite(50, 11, 16, 16);

            playerLeft = new BufferedImage[2];
            playerLeft[0] = Spritesheet.getSprite(34, 11, 16, 16);
            playerLeft[1] = Spritesheet.getSprite(50, 11, 16, 16);

            borderWall = Spritesheet.getSprite(172, 185, 16, 16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }
}
