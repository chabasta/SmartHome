package device.devices;

import device.Device;
import device.state.ActiveState;
import device.state.IdleState;

public class Fireplace extends Device {

    public Fireplace(String name) {
        super(name, 5, 2, 0, 0, 3, 1);
    }

    /**
     * function measures energy consumption of gas or water
     * @param time
     */
    public void calculate(double time){
        if (state instanceof ActiveState) {
            setTotalGas(getTotalGas() + (Math.abs(endTime - startTime) * getConsumptionOfGasActive()));
            setTotalElectricity(getTotalElectricity() + (Math.abs(endTime - startTime) * getConsumptionOfElectricityActive()));
        } else if (state instanceof IdleState) {
            setTotalGas(getTotalGas() + (Math.abs(endTime - startTime) * getConsumptionOfGasIdle()));
            setTotalElectricity(getTotalElectricity() + (Math.abs(endTime - startTime) * getConsumptionOfElectricityIdle()));
        }
    }

    @Override
    public String toString() {
        return "Fireplace";
    }
}
