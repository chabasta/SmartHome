package resident.humans;

//import device.devices.Bike;
//import device.devices.Ski;
import device.Device;
import events.Activity;
import events.Event;
import events.EventHistory;
import house.House;
import resident.Resident;


import java.util.Random;

public class Human extends Resident  {

    private final boolean isChild;
    private Device usingTransport = null;

    public Human(String name, House house, boolean isChild) {
        super(name, house);
        this.isChild = isChild;
    }

    /**
     * if some kind of transport is not used, then EventsToDo are done first of all,
     * then with a random chance a person can use the device in the room with him,
     *  go to another room,perform a personal action or do nothing
     */
    public void doAction() {
        if (usingTransport == null) {
            if ( !isChild && EventHistory.eventsToDo.size() != 0) {
                Event eventToFinish = EventHistory.eventsToDo.get(0);
                eventToFinish.finish(curTime, this);
                house.getEventHistory().addToFinishedEvents(eventToFinish);
            } else {
                Random random = new Random();
                int num = random.nextInt(100);
                if (num <= 25) {
                    if (this.location.getDevices().isEmpty()) {
                        return;
                    }
                    int deviceNum = random.nextInt(location.getDevices().size());
                    Device device = location.getDevices().get(deviceNum);
                    if (device.toString().matches("Ski|Bike") && !device.isUsed()){
                        usingTransport = location.getDevices().get(deviceNum);
                        location.getDevices().remove(usingTransport);
                    }
                    if (device.isBroken() && isChild){
                        activities.add(new Activity(this, "Ask some adult to repair device", device.toString()));
                    }else updateDevice(device);

                } else if (num <= 40) {
                    moveToOtherRoom(random);
                } else if (num <= 50) {
                    doPersonalAction();
                }else {
                    activities.add(new Activity(this, "Done nothing"));
                }
            }
        }else{
            if (usingTransport.getTimeUsage() != 0){
                usingTransport.setTimeUsage(usingTransport.getTimeUsage() - 1);
            }
            else {
                usingTransport.setUsed(false);
                location.getDevices().add(usingTransport);
                usingTransport = null;
            }
        }
    }

}
