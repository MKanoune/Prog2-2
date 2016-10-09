package Entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by max on 07.10.16.
 */
public class MasterSquirrel extends Entity {
    private ArrayList<Entity> entities;
    private int direction;

    public MasterSquirrel(int id, int x, int y) {
        super(id, 1000, x, y);
    }


    //Give the squirrel all entities to check the further positions
    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


    // Create new Position with a helper method @XY
    public void nextStep() {
        XY newPos = this.getPosition().getNewPosSquirrel(direction);
        checkNextPosition(entities, newPos);
        this.setPosition(newPos);
    }

    // Method to set the userInput from the Game Class
    public void getUserInput(int direction) { this.direction = direction; }


    //check if a miniSquirrel is created by this masterSq.
    public boolean isMiniSquirrel(Entity entity) {
        if (entity instanceof MiniSquirrel) {
            if (this.getId() == entity.getId()) {
                return true;
            }
        }
        return false;
    }


    /*
    * create a new miniSquirrel with the same id as the Master and give it something of the
    * own energy. -> check if @energy is too big for the MasterSquirrel
    */
    public MiniSquirrel createMiniSquirrel(int energy) {
        if (this.getEnergy() <= energy) {
            System.out.println("Gewünschte Energie für das MiniSquirrel ist zu groß");
            return null;
        }

        MiniSquirrel miniSquirrel =  new MiniSquirrel(this.getId(), this.getPosition().getX(), this.getPosition().getY());
        miniSquirrel.updateEnergy(-(1000 - energy));
        return miniSquirrel;
    }


    /*
    * method to check the next position where the Squirrel will move to.
    * to do this we need to iterate over all entities and compare the XY position.
    * Afterwards we check the type with 'instanceof'
     */
    public void checkNextPosition(ArrayList<Entity> entities, XY nextPos) {
        for (Entity e : entities) {
            if (nextPos.getX() == e.getPosition().getX()) {
                if (nextPos.getY() == e.getPosition().getY()) {

                    if (e instanceof GoodPlant) {
                        this.updateEnergy(e.getEnergy());
                        e.setAlive(false);
                    } else {
                        //toDo: handle other entities
                    }
                }
            }
        }
    }


    public String toString() {
        return "X Pos: " +this.getPosition().getX() +" Y Pos: " +this.getPosition().getY() +" " +this.getEnergy();
    }
}
