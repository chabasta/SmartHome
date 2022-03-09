package resident.humans;

import events.Activity;
import house.House;

import java.util.Random;

public class Baby extends Human{

    public Baby(String name, House house) {
        super(name, house, true);
    }

    /**
     * function representing personal actions of a person
     */
    @Override
    public void doPersonalAction() {
        Random rnd = new Random();
        switch (rnd.nextInt(5)) {
            case 0 -> {
                activities.add(new Activity(this, "Said Mama"));
            }
            case 1 -> {
                activities.add(new Activity(this, "Said Papa"));
            }
            case 2 -> {
                activities.add(new Activity(this, "Said agoo"));
            }
            case 3 -> {
                activities.add(new Activity(this, "Cried"));
            }
            case 4 -> {
                activities.add(new Activity(this, "Looked at toys"));
            }
        }
    }

}
