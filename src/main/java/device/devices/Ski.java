package device.devices;

import device.Device;
import device.state.*;
import events.Event;
import events.EventHistory;

import java.util.Random;

public class Ski extends Device {

    Random rand = new Random();

    public Ski(String name) {
        super(name, 0, 0, 0, 0, 0, 0);
    }

    /**
     * Function changes the state of devices
     * @param time
     */
    @Override
    public void setState(double time) {
        state.setDevice(this);
        int x = rand.nextInt(100);
        if (x <= 95) { // 95% chance
            timeUsage = rand.nextInt(50);
            used = true;
            state.nextState(time);
        } else {
            state = new BrokenState();
            EventHistory.eventsToDo.add(new Event("DeviceNeedsToBeRepaired", time, this));
        }
    }

    @Override
    public String toString() {
        return "Ski";
    }
}
