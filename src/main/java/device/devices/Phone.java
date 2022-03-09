package device.devices;

import device.Device;
import device.state.ActiveState;
import device.state.IdleState;

public class Phone extends Device {
    public Phone(String name) {
        super(name,0, 0, 0, 0, 7, 3);
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
        return "Phone";
    }

}
