package Entities;

/**
 * Created by Max on 06.10.2016.
 */
public abstract class Entity {
    private final int id;
    private int energy;
    private XY position;

    public Entity(int id, int energy, int x, int y) {
        this.id = id;
        this.energy = energy;
        position = new XY(x, y);
    }

    //standart getter & setter methods
    public int getId() { return id; }

    public int getEnergy() { return energy; }

    public XY getPosition() { return position; }

    public void setEnergy(int deltaE) {
        energy += deltaE;
    }

    public void setPosition(XY newPos) {
        position = newPos;
    }

    //nextStep is what each Entity does
    public abstract void nextStep();

}
