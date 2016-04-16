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

    public CircleHitNode(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public boolean intersects(HitNode otherNode) {
        if(otherNode instanceof CircleHitNode) {
            if(Math.hypot(this.getX()-otherNode.getX(),this.getY()-otherNode.getY()) < this.getRadius() + ((CircleHitNode) otherNode).getRadius()) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new NotImplementedException();
        }
    }
}
