package resident.pets;

import events.Activity;
import house.House;

import java.util.Random;

public class Dog extends Pet{

    public Dog(String name, House house) {
        super(name, house);
    }

    /**
     * function representing the personal actions of the pet
     */
    @Override
    public void doPersonalAction() {
        Random rnd = new Random();
        switch (rnd.nextInt(5)) {
            case 0:
                activities.add(new Activity(this,"Felt nostalgic for his youth"));
                break;
            case 1:
                activities.add(new Activity(this, "Smoked cigar"));
                break;
            case 2:
                activities.add(new Activity(this, "Left home"));
                break;
            case 3:
                activities.add(new Activity(this, "Read a book"));
                break;
            case 4:
                activities.add(new Activity(this, "Yelled"));
                break;
        }
    }
}
