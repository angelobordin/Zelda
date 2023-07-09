package classes;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {
    public static BufferedImage spritesheet;
    public static BufferedImage playerFront;
    public static BufferedImage borderWall;

    public Spritesheet() {
        try {
            spritesheet = ImageIO.read(new FileInputStream("res/spritesheet.png"));
            playerFront = Spritesheet.getSprite(0, 11, 16, 16);
            borderWall = Spritesheet.getSprite(191, 185, 16, 16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getSprite(int x, int y, int width, int height) {
        return spritesheet.getSubimage(x, y, width, height);
    }
}
