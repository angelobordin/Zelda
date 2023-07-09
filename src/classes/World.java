package classes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {

    public static List<Block> blocos = new ArrayList<Block>();

    public World() {
        // Generate world border
        for (int xx = 0; xx < 32; xx++) {
            blocos.add(new Block(xx * 32, 0));
        }

        for (int yy = 0; yy < 24; yy++) {
            blocos.add(new Block(0, yy * 32));
        }

        for (int xx = 0; xx < 32; xx++) {
            blocos.add(new Block(xx * 32, 736));
        }

        for (int yy = 0; yy < 24; yy++) {
            blocos.add(new Block(992, yy * 32));
        }
    };

    public static boolean isColliding(int x, int y) {
        for (Block bloco : blocos) {
            if (bloco.intersects(new Rectangle(x, y, 32, 32))) {
                return true;
            }
        }

        return false;
    };

    public void render(Graphics graphicModule) {
        for (Block block : blocos) {
            block.render(graphicModule);
        }
    }

}
