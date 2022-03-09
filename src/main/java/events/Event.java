package events;

import device.Device;
import resident.Resident;
import resident.pets.Pet;

public class Event {

    private final String    type;
    private double          endTime = 0;
    private double          startTime = 0;
    private Resident        resident;
    private Device          device;
    private Pet             pet;

    public Event(String type, double startTime, Pet pet) {
        this.type = type;
        this.startTime = startTime;
        this.pet = pet;
    }

    public Event(String type, double startTime, Device device) {
        this.type = type;
        this.startTime = startTime;
        this.device = device;
    }

    public void finish(double endTime, Resident resident) {
        this.endTime = endTime;
        this.resident = resident;
    }

    public String getType() {
        return type;
    }

    public Resident getResident() {
        return resident;
    }

    @Override
    public String toString() {
        return "Event{" +
                "type='" + type + '\'' +
                ", endTime=" + endTime +
                ", startTime=" + startTime +
                ", resident=" + resident +
                ", device=" + device +
                ", pet=" + pet +
                '}';
    }
}
