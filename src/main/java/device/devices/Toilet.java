package device.devices;

import device.Device;
import device.state.*;

//class representing toilet
//active-state - toilet is used once
public class Toilet extends Device {

    public Toilet(String name) {
        super(name,0, 0, 10, 0, 0, 0);
    }

    @Override
    public void setState(double time) {
        oneTimeUsage();
    }

    @Override
    public void oneTimeUsage() {
        setState(new ActiveState());
        setTotalWater(getTotalWater()+getConsumptionOfWaterActive());
        setState(new TurnedOffState());
    }


    @Override
    public String toString() {
        return "Toilet";
    }
}
