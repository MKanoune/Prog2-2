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

    public MasterSquirrel(int id, int x, int y) {
        super(id, 1000, x, y);
    }


    /*
    * Give the Squirrel all entities 'cause it needs to check it's further posistions.
    * Also give the miniSquirrels (same ID) all entities.
     */
    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


    /*
    * Read from the console and give the input value to the newPos method.
    * For Instructions read the comment @XY.getNewPosSquirrel(int direction)
     */
    public void nextStep() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int direction = 0;
        try {
            String line = br.readLine();
            direction = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        XY newPos = this.getPosition().getNewPosSquirrel(direction);
        checkNextPosition(entities, newPos);
        this.setPosition(newPos);
    }


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
        miniSquirrel.setEnergy(-(1000 - energy));
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
                        this.setEnergy(e.getEnergy());
                        // toDo: remove good Plant
                    } else {
                        //toDo: handle other entities
                    }
                }
            }
        }
    }


    public String toString() {
        return "ID: " +this.getId() +" mit einem Energiewert von " +this.getEnergy();
    }
}
