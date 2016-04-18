package model.collision;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created 4/18/16
 *
 * @author Niels Norberg
 */
public class SquareHitNode extends HitNode {
    private int radius;

    public SquareHitNode(int x, int y, Hitbox parent, int radius) {
        super(x, y, parent);
        this.radius = radius;
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
