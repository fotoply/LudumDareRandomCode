import model.Entity;
import model.collision.Collideable;
import model.collision.Hitbox;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public class RandomObject extends Entity implements Collideable {
    private Hitbox hitbox;

    @Override
    public Hitbox getHitbox() {
        return hitbox;
    }

    public RandomObject() {
        this.hitbox = new Hitbox(this);
        hitbox.setOuterPerimeter(0,0,2);
    }

    @Override
    public boolean collidesWith(Collideable otherCollideable) {
        return false;
    }
}
