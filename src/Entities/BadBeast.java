package Entities;

/**
 * Created by max on 07.10.16.
 */
public class BadBeast extends Entity {
    private int leftBites = 7;

    public BadBeast(int id, int x, int y) {
        super(id, -150, x, y);
    }

    public void nextStep() {
        this.setPosition(this.getPosition().getNewPos());
    }
}
