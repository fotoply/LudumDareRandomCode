package model;

import model.collision.HitNode;
import model.collision.Hitbox;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public class Entity {

    private int x;
    private int y;
    private Hitbox hitbox;

    public Hitbox getHitbox() {
        return hitbox;
    }

    public void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean intersects(Entity otherObject) {
         return otherObject.getHitbox().intersectsWith(this.getHitbox());
    }
}
