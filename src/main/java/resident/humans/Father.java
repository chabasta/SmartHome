package resident.humans;

import events.Activity;
import house.House;

import java.util.Random;

public class Father extends Human{

    public Father(String name, House house) {
        super(name, house, false);
    }

    /**
     * function representing personal actions of a person
     */
    @Override
    public void doPersonalAction() {
        Random rnd = new Random();
        switch (rnd.nextInt(5)) {
            case 0 -> {
                activities.add(new Activity(this, "Felt nostalgic for his youth"));
            }
            case 1 -> {
                activities.add(new Activity(this, "Smoked cigar"));
            }
            case 2 -> {
                activities.add(new Activity(this, "Left home"));
            }
            case 3 -> {
                activities.add(new Activity(this, "Read a book"));
            }
            case 4 -> {
                activities.add(new Activity(this, "Drank beer"));
            }
        }
    }
}
