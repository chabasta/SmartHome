package device.devices;

import device.Device;
import device.state.ActiveState;
import device.state.IdleState;

public class PC extends Device {

    public PC(String name) {
        super(name, 0, 0, 0, 0, 10, 4);
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
        return "PC";
    }

}
