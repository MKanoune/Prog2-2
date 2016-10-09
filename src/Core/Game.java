package Core;

import Entities.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by max on 07.10.16.
 */
public class Game {
    private ArrayList<Entity> entities = new ArrayList<>();

    public void run() {
        int counter = 1;
        while(true) {
            render();
            processInput(counter);
            update(counter);
            counter++;
        }
    }

    public void render() {
        for (Entity e : entities) {
            if (e instanceof MasterSquirrel) {
                System.out.println(e.toString());
            }
        }
    }

    // get the userInput for all Master/Mini Squirrels
    public void processInput(int counter) {
         for (Entity e : entities) {
             if (e instanceof MasterSquirrel) {
                 MasterSquirrel dummy = (MasterSquirrel) e;
                 dummy.getUserInput(processInputHelper());
             } else if (e instanceof MiniSquirrel) {
                 MiniSquirrel dummy = (MiniSquirrel) e;
                 dummy.getUserInput(processInputHelper());
             }
         }
    }


    // helper method to read user input from console
    public int processInputHelper() {
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
        return direction;
    }


    /*
    * Beasts are just allowed to do the nextStep() every 4th round.
    * Update all entities and look for entities that are not alive
    * through the @alive param.
    * Spawn death entities and random positions.
     */
    public void update(int counter) {
        if (counter % 4 == 0) {
            for (Entity e : entities) {
                e.nextStep();
            }
        } else {
            for (Entity e : entities) {
                if (e instanceof MasterSquirrel || e instanceof MiniSquirrel) {
                    e.nextStep();
                }
            }
        }
        for (Entity e : entities) {
            if (!e.isAlive()) {
                e.setPosition(e.getPosition().getNewPos());
                System.out.println(e.toString());
            }
        }
    }


    public static void main(String[] args) {
        /*
        * just create some entities and add them to an ArrayList<Entitiy>.
        * Squirrels must be created with an reference variable which is added
        * to the list afterwards.
        * ( Cause masterSq. can't create miniSq. inside the list (List of Entities))
         */
        Game game = new Game();
        game.entities.add(new GoodBeast(0, 10, 5));
        game.entities.add(new Wall(1, 1, 1));
        game.entities.add(new GoodPlant(2, 4, 2));
        MasterSquirrel master = new MasterSquirrel(3, 2, 2);
        MiniSquirrel mini = master.createMiniSquirrel(200);
        game.entities.add(master);
//        game.entities.add(mini);
        master.setEntities(game.entities);

        game.run();

    }
}
