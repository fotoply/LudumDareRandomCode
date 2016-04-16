package collision;

import java.util.ArrayList;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public class Hitbox {

    private ArrayList<HitNode> nodes;

    public Hitbox() {
        nodes = new ArrayList<>();
    }

    public void addNode(HitNode node) {
        nodes.add(node);
    }

    public boolean intersectsWith(Hitbox otherHitbox) {
        for (HitNode node: nodes) {
            for (HitNode otherNode: otherHitbox.nodes) {
                if(node.intersects(otherNode)) {
                    return true;
                }
            }
        }
        return false;
    }

}
