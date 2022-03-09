package resident.humans;

import events.Activity;
import house.House;

import java.util.Random;

public class Daughter extends Human{
    public Daughter(String name, House house) {
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
                activities.add(new Activity(this, "did school assignments"));
            }
            case 1 -> {
                activities.add(new Activity(this, "Talked to girlfriends"));
            }
            case 2 -> {
                activities.add(new Activity(this, "Made origami"));
            }
            case 3 -> {
                activities.add(new Activity(this, "Read a book"));
            }
            case 4 -> {
                activities.add(new Activity(this, "Danced"));
            }
        }
    }
}

