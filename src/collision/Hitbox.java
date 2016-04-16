package collision;

import java.util.ArrayList;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public class Hitbox {

    private ArrayList<HitNode> nodes;
    private HitNode outerPerimeter;

    public Hitbox() {
        nodes = new ArrayList<>();
    }

    public void setOuterPerimeter(int x, int y, int radius) {
        outerPerimeter = new CircleHitNode(x, y, radius);
    }

    public void addNode(HitNode node) {
        nodes.add(node);
    }

    public boolean intersectsWith(Hitbox otherHitbox) {
        if(this.outerPerimeter.intersects(otherHitbox.outerPerimeter)) {
            for (HitNode node : nodes) {
                for (HitNode otherNode : otherHitbox.nodes) {
                    if (node.intersects(otherNode)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
