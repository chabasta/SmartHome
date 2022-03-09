package device.devices;

import device.Device;
import device.state.ActiveState;
import device.state.IdleState;

public class WashMachine extends Device {
    public WashMachine(String name) {
        super(name,0, 0, 25, 0, 10, 0);
    }

    /**
     * function measures energy consumption of gas or water
     * @param time
     */
    public void calculate(double time){
        if (state instanceof ActiveState) {
            setTotalElectricity(getTotalElectricity() + (Math.abs(endTime - startTime) * getConsumptionOfElectricityActive()));
            setTotalWater(getTotalWater() + (Math.abs(endTime - startTime) * getConsumptionOfWaterActive()));
        } else if (state instanceof IdleState) {
            setTotalElectricity(getTotalElectricity() + (Math.abs(endTime - startTime) * getConsumptionOfElectricityIdle()));
            setTotalWater(getTotalWater() + (Math.abs(endTime - startTime) * getConsumptionOfWaterIdle()));
        }
    }

    @Override
    public String toString() {
        return "WashMachine";
    }
}
