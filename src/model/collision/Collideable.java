package model.collision;

import model.collision.Hitbox;

/**
 * Created 4/16/16
 *
 * @author Niels Norberg
 */
public interface Collideable {
    boolean collidesWith(Collideable otherCollideable);
    Hitbox getHitbox();
}
