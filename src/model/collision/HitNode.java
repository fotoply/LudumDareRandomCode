package model.collision;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public abstract class HitNode {

    private int x;
    private int y;
    private Hitbox parent;

    public HitNode(int x, int y, Hitbox parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }
    public abstract boolean intersects(HitNode otherNode);

    public abstract boolean intersects(HitNode otherNode, boolean shouldReverse);

    public int getRelativeX() {
        return x;
    }

    public int getRelativeY() {
        return y;
    }

    public int getX() {
        return x + parent.getX();
    }

    public int getY() {
        return y + parent.getY();
    }
}
