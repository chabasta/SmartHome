package resident.pets;

import events.Activity;
import events.Event;
import house.House;
import resident.Resident;
import resident.humans.Human;

import java.util.Random;

public class Pet extends Resident {

    public Pet(String name, House house) {
        super(name, house);
    }

    /**
     * The function represents the actions of the pet
     */
    @Override
    public void doAction() {
        Random random = new Random();
        int num = random.nextInt(100);
        if (num <= 1 && location.getResidents().stream().filter(a -> a instanceof Human).findFirst().isPresent()) {
            activities.add(new Activity(this, "Wanted to be petted"));
            house.getEventHistory().addToEventsToDo(new Event("InNeedOfLoveAnimal",curTime,this));
        } else if (num <= 2 && location.getResidents().stream().filter(a -> a instanceof Human).findFirst().isPresent()) {
            activities.add(new Activity(this, "Got hungry"));
            house.getEventHistory().addToEventsToDo(new Event("HungryAnimal",curTime,this));
        } else if (num <= 40) {
            moveToOtherRoom(random);
        } else if (num <= 60) {
            doPersonalAction();
        } else {
            activities.add(new Activity(this, "Done nothing"));
        }
    }

}
