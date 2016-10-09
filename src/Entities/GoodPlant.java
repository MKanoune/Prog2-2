package Entities;

/**
 * Created by max on 07.10.16.
 */
public class GoodPlant extends Entity {

    public GoodPlant(int id, int x, int y) {
        super(id, 150, x, y);
    }

    public void nextStep() {

    }

    public String toString() {
        return "X Pos: " +this.getPosition().getX() +" Y Pos: " +this.getPosition().getY() +" " +this.getEnergy();
    }
}
