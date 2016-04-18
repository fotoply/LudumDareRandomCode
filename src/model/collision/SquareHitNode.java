package model.collision;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created 4/18/16
 *
 * @author Niels Norberg
 */
public class SquareHitNode extends HitNode {
    private int rightEdge;
    private int bottomEdge;

    public SquareHitNode(int x, int y, Hitbox parent, int width, int height) {
        super(x, y, parent);
        this.rightEdge = x + width;
        this.bottomEdge = y + height;
    }

    @Override
    public boolean intersects(HitNode otherNode) {
        return intersects(otherNode, true);
    }

    @Override
    public boolean intersects(HitNode otherNode, boolean shouldReverse) {
        if (otherNode instanceof SquareHitNode) {
            return squaresIntersect(this, (SquareHitNode) otherNode);
        } else if (otherNode instanceof CircleHitNode) {
            return squareCircleIntersect(this, (CircleHitNode) otherNode);
        } else if (shouldReverse) { //Must always be the last else-if, only followed by the else
            return otherNode.intersects(this, false);
        } else {
            throw new NotImplementedException();
        }
    }

    private boolean squaresIntersect(SquareHitNode thisNode, SquareHitNode otherNode) {
        if (thisNode.rightEdge < otherNode.getX() &&
                thisNode.getX() > otherNode.rightEdge &&
                thisNode.getY() < otherNode.bottomEdge &&
                thisNode.bottomEdge > otherNode.getY()) {
            return false;
        }
        return true;
    }

    private boolean squareCircleIntersect(SquareHitNode thisNode, CircleHitNode otherNode) {

        return true;
    }
}
