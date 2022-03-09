package device.devices;

import device.Device;
import device.state.ActiveState;
import device.state.IdleState;

public class Stove extends Device {

    public Stove(String name) {
        super(name,7, 3, 0, 0, 0, 0);
    }


    /**
     * function measures energy consumption of gas or water
     * @param time
     */
    public void calculate(double time){
        if (state instanceof ActiveState) {
            setTotalGas(getTotalGas() + (Math.abs(endTime - startTime) * getConsumptionOfGasActive()));
        } else if (state instanceof IdleState) {
            setTotalGas(getTotalGas() + (Math.abs(endTime - startTime) * getConsumptionOfGasIdle()));
        }
    }

    @Override
    public String toString() {
        return "Stove";
    }
}
