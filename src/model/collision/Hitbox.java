package model.collision;

import model.Entity;

import java.util.ArrayList;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public class Hitbox {

    private ArrayList<model.collision.HitNode> nodes;
    private model.collision.HitNode outerPerimeter;
    private Entity parent;

    public Hitbox(Entity parent) {
        nodes = new ArrayList<>();
        this.parent = parent;
    }

    public void setOuterPerimeter(int x, int y, int radius) {
        outerPerimeter = new model.collision.CircleHitNode(x, y, this,radius);
    }

    public void addNode(model.collision.HitNode node) {
        nodes.add(node);
    }

    public boolean intersectsWith(Hitbox otherHitbox) {
        if(this.outerPerimeter.intersects(otherHitbox.outerPerimeter)) {
            for (model.collision.HitNode node : nodes) {
                for (model.collision.HitNode otherNode : otherHitbox.nodes) {
                    if (node.intersects(otherNode)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getX() {
        return parent.getX();
    }

    public int getY() {
        return parent.getY();
    }

}
