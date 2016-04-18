package model.collision;

import model.collision.HitNode;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public class CircleHitNode extends HitNode {
    private int radius;
    private Hitbox parent;

    public CircleHitNode(int x, int y, Hitbox parent, int radius) {
        super(x, y, parent);
        this.radius = radius;
        this.parent = parent;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean intersects(HitNode otherNode) {
        return intersects(otherNode, true);
    }

    @Override
    public boolean intersects(HitNode otherNode, boolean shouldReverse) {
        if(otherNode instanceof CircleHitNode) {
            return Math.hypot(this.getX()-otherNode.getX(),this.getY()-otherNode.getY()) < this.getRadius() + ((CircleHitNode) otherNode).getRadius();
        } else if(shouldReverse) { //Must always be the last else-if, only followed by the else
            return otherNode.intersects(this,false);
        } else {
            throw new NotImplementedException();
        }
    }
}
