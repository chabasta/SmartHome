package resident;

import device.Device;
import device.state.*;
import events.Activity;
import house.House;
import house.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Resident {

    protected String name;
    protected Room location;
    protected double curTime = 0;
    protected House house;
    protected List<Activity> activities = new ArrayList<>();

    public Resident(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public Resident(String name, Room location, House house) {
        this.name = name;
        this.location = location;
        this.house = house;
    }

    public void setLocation(Room location) {
        this.location = location;
    }

    /**
     * Function for creating actions
     * @param device (what resident want to use)
     */
    public void updateDevice(Device device) {
        State startState = device.getState();
        device.setState(curTime);
        State endState = device.getState();
        if( (device.toString().equals("Ski") || device.toString().equals("Bike"))){
            if (endState.toString().equals("TurnedOffState"))activities.add(new Activity(this, "Used transport", device.toString()));
        }else {
            if (endState.toString().equals("TurnedOffState")) {
                if (startState.toString().equals("TurnedOffState")) {
                    activities.add(new Activity(this, "One time usage of device", device.toString()));
                }else if (startState.toString().equals("BrokenState")) {
                    activities.add(new Activity(this, "Repaired device", device.toString()));
                }
                else {
                    activities.add(new Activity(this, "Turned off device", device.toString()));
                }
            } else if (endState.toString().equals("IdleState")) {
                activities.add(new Activity(this, "Turned on idle usage of device", device.toString()));
            } else {
                activities.add(new Activity(this, "Turned on device", device.toString()));
            }
        }
    }

    public void doAction() {
    }

    public void doPersonalAction() {
    }

    /**
     * The function moves a person or pet to another room
     * @param random
     */
    protected void moveToOtherRoom(Random random) {
        location.getResidents().remove(this);
        int roomNum = random.nextInt(house.getAllRooms().size());
        Room roomToMoveTo = house.getAllRooms().get(roomNum);
        roomToMoveTo.getResidents().add(this);
        this.location = roomToMoveTo;
        activities.add(new Activity(this, "Moved to other room", location.toString()));
    }

    public List<Activity> getActivities() {
        return activities;
    }

    @Override
    public String toString() {
        return name;
    }
}
