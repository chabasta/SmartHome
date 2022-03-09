package device.devices;

import device.Device;
import device.state.ActiveState;
import device.state.IdleState;

//class representing tv
//idle-state - eco-friendly mode is turned on
//active-state - eco-friendly mode is turned off
public class TV extends Device {

    public TV(String s) {
        super(s,0, 0, 0, 0, 10, 5);
    }


    /**
     * function measures energy consumption of gas or water
     * @param time
     */
    public void calculate(double time){
        if (state instanceof ActiveState) {
            setTotalElectricity(getTotalElectricity() + (Math.abs(endTime - startTime) * getConsumptionOfElectricityActive()));
        } else if (state instanceof IdleState) {
            setTotalElectricity(getTotalElectricity() + (Math.abs(endTime - startTime) * getConsumptionOfElectricityIdle()));
        }
    }

    @Override
    public String toString() {
        return "TV";
    }
}

