package Entities;

/**
 * Created by max on 07.10.16.
 */
public class Wall extends Entity {

    public Wall(int id, int x, int y) {
        super(id, -10, x, y);
    }

    public void nextStep() {    }
    
    public String toString() {
    	return "ID:" +this.getId() +" x: " +this.getPos().getX() +" y: " +this.getPos().getY();
    }
}
