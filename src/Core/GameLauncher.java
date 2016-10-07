package Core;

import Entities.*;

import java.util.ArrayList;

/**
 * Created by max on 07.10.16.
 */
public class GameLauncher {

    public static void main(String[] args) {
        /*
        * just create some entities and add them to an ArrayList<Entitiy>.
        * Squirrels must be created with an reference variable which is added
        * to the list afterwards.
        * ( Cause masterSq. can't create miniSq. inside the list (List of Entities))
         */
        ArrayList<Entity> entities = new ArrayList<>();
        entities.add(new GoodBeast(0, 10, 5));
        entities.add(new Wall(1, 1, 1));
        entities.add(new GoodPlant(2, 4, 2));
        MasterSquirrel master = new MasterSquirrel(3, 2, 2);
        MiniSquirrel mini = master.createMiniSquirrel(200);
        entities.add(master);
        entities.add(mini);
        master.setEntities(entities);

        for (int i = 0; i < 3; i++) {
            for (Entity e : entities) {
                e.nextStep();
            }
        }

        System.out.println(entities.get(2).toString());

    }
}
