package events;

import resident.Resident;

public class Activity {

    private final Resident  resident;
    private final String    firstArg;
    private       String    secondArg = null;

    public Activity(Resident resident, String firstArg) {
        this.resident = resident;
        this.firstArg = firstArg;
    }

    public Activity(Resident resident, String firstArg, String secondArg) {
        this.resident = resident;
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }

    public Resident getResident() {
        return resident;
    }

    public String getFirstArg() {
        return firstArg;
    }

    public String getSecondArg() {
        return secondArg;
    }

    @Override
    public String toString() {
        if (secondArg != null) {
            return resident + " " + firstArg + " " + secondArg;
        } return resident + " " + firstArg;
    }
}
