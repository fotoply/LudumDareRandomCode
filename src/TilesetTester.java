import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

/**
 * Created 4/15/16
 *
 * @author Niels Norberg
 */
public class TilesetTester extends PApplet {
    Tileset tileset = new Tileset(32,32,this);
    Random rnd = new Random();
    PImage item;
    int counter = 0;

    public static void main(String args[]) {
        PApplet.main(new String[] { "--present", "TilesetTester" });
    }

    public void setup() {
        tileset.loadTileset("testApple.jpg");
        System.out.println("Loaded tileset");
        item = tileset.getSprite(10,10);
    }

    public void draw() {
        background(0);
        counter++;
        if(counter%40 == 0) {
            item = tileset.getSprite(rnd.nextInt(tileset.getHorizontalTiles()),rnd.nextInt(tileset.getVerticalTiles()));
        }

        set(mouseX,mouseY,item);
    }
}
