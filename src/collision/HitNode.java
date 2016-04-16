package collision;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public abstract class HitNode {

    private int x;
    private int y;

    public HitNode(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract boolean intersects(HitNode otherNode);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
