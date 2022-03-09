package resident.humans;

import events.Activity;
import house.House;

import java.util.Random;

public class Son extends Human {
    public Son(String name, House house) {
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
                activities.add(new Activity(this, "Played with a ball"));
            }
            case 1 -> {
                activities.add(new Activity(this, "Plays computer games"));
            }
            case 2 -> {
                activities.add(new Activity(this, "Did sport"));
            }
            case 3 -> {
                activities.add(new Activity(this, "Read a book"));
            }
            case 4 -> {
                activities.add(new Activity(this, "Stole dad's beer"));
            }
        }
    }
}

