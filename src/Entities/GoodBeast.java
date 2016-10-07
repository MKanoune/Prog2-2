package Entities;

/**
 * Created by max on 07.10.16.
 */
public class GoodBeast extends Entity {

    public GoodBeast(int id, int x, int y) {
        super(id, 200, x, y);
    }

    public void nextStep() {
        this.setPosition(this.getPosition().getNewPos());
    }
}
