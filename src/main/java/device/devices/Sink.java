package device.devices;

import device.Device;
import device.state.ActiveState;
import device.state.IdleState;

public class Sink extends Device {

    public Sink(String name) {
        super(name, 0, 0, 5, 3, 0, 0);
    }

    /**
     * function measures energy consumption of gas or water
     * @param time
     */
    public void calculate(double time){
        if (state instanceof ActiveState) {
            setTotalWater(getTotalWater() + (Math.abs(endTime - startTime) * getConsumptionOfWaterActive()));
        } else if (state instanceof IdleState) {
            setTotalWater(getTotalWater() + (Math.abs(endTime - startTime) * getConsumptionOfWaterIdle()));
        }
    }

    @Override
    public String toString() {
        return "Sink";
    }
}
