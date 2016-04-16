import com.sun.istack.internal.NotNull;
import com.sun.javaws.exceptions.InvalidArgumentException;
import processing.core.PApplet;
import processing.core.PImage;

import java.io.File;

/**
 * Created 4/15/16
 *
 * @author Niels Norberg
 */
public class Tileset {
    private int spriteWidth;
    private int spriteHeight;
    private PImage spritesheet;
    private PApplet parent;

    public Tileset(int spriteWidth, int spriteHeight, PApplet parent) {
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        this.parent = parent;
    }

    PImage getSprite(int spriteX, int spriteY) {
        if(spritesheet == null) {
            throw new NullPointerException("No spritesheet loaded");
        }
        if(spriteX > getHorizontalTiles() || spriteY > getVerticalTiles()) {
            throw new IllegalArgumentException("Non-existing sprite");
        }
        return spritesheet.get(spriteX*spriteWidth, spriteY*spriteHeight, spriteWidth, spriteHeight);
    }

    void loadTileset(@NotNull String file) {
        if(!file.isEmpty()) {
            PImage newSheet = parent.loadImage(file);
            if(newSheet.width%spriteWidth != 0 || newSheet.height%spriteHeight != 0) {
                throw new IllegalArgumentException("Tilesheet has an invalid height or width(" + newSheet.width + "/" + newSheet.height + ")");
            }
            spritesheet = newSheet;
        }
    }

    public int getVerticalTiles() {
        if(spritesheet == null) {
            throw new NullPointerException("No spritesheet loaded");
        }
        return spritesheet.height/spriteHeight;
    }

    public int getHorizontalTiles() {
        if(spritesheet == null) {
            throw new NullPointerException("No spritesheet loaded");
        }
        return spritesheet.width/spriteWidth;
    }
}
