package resident.pets;

import events.Activity;
import house.House;

public class Penguin extends Pet{
    public Penguin(String name, House house) {
        super(name, house);
    }


    /**
     * function representing the personal actions of the pet
     */
    @Override
    public void doPersonalAction() {
        activities.add(new Activity(this,"grunted"));
    }
}
