package device;

import device.state.BrokenState;
import device.state.State;
import device.state.TurnedOffState;
import events.Event;
import events.EventHistory;
import java.util.Random;

public abstract class Device {

    private final double consumptionOfGasActive;
    private final double consumptionOfGasIdle;

    private final double consumptionOfWaterActive;
    private final double consumptionOfWaterIdle;

    private final double consumptionOfElectricityActive;
    private final double consumptionOfElectricityIdle;

    private double totalGas         = 0;
    private double totalWater       = 0;
    private double totalElectricity = 0;

    protected double  endTime       = 0;
    protected double  startTime     = 0;
    protected int     timeUsage     = 0;
    protected boolean used          = false;
    protected State   state;
    private final String name;

    Random rand = new Random();

    public Device(String name, int consumptionOfGasActive, int consumptionOfGasIdle, int consumptionOfWaterActive, int consumptionOfWaterIdle, int consumptionOfElectricityActive, int consumptionOfElectricityIdle) {
        this.name = name;
        this.state = new TurnedOffState();
        this.consumptionOfGasActive = consumptionOfGasActive;
        this.consumptionOfGasIdle = consumptionOfGasIdle;
        this.consumptionOfWaterActive = consumptionOfWaterActive;
        this.consumptionOfWaterIdle = consumptionOfWaterIdle;
        this.consumptionOfElectricityActive = consumptionOfElectricityActive;
        this.consumptionOfElectricityIdle = consumptionOfElectricityIdle;
    }

    /**
     * Function changes the state of devices
     * @param time (actual time in simulation)
     */
    public void setState(double time) {
        state.setDevice(this);
        int x = rand.nextInt(100);
        if (x <= 95) state.nextState(time); // 95% chance
        else {
            state = new BrokenState();
            EventHistory.eventsToDo.add(new Event("DeviceNeedsToBeRepaired", time, this));
        }
    }

    public void setState(State st) {
        this.state = st;
    }

    /**
     * Function turns off all devices
     * @param time (actual time in simulation)
     */
    public void stop(double time) {
        if (!(this.state instanceof TurnedOffState)) {
            endTime = time;
            setState(new TurnedOffState());
        }
    }
    public boolean isBroken(){
        return state.toString().equals("BrokenState");
    }

    public void oneTimeUsage() {}

    public double getConsumptionOfGasActive() {
        return consumptionOfGasActive;
    }

    public double getConsumptionOfGasIdle() {
        return consumptionOfGasIdle;
    }

    public double getConsumptionOfWaterActive() {
        return consumptionOfWaterActive;
    }

    public double getConsumptionOfWaterIdle() {
        return consumptionOfWaterIdle;
    }

    public double getConsumptionOfElectricityActive() {
        return consumptionOfElectricityActive;
    }

    public double getConsumptionOfElectricityIdle() {
        return consumptionOfElectricityIdle;
    }

    public void setTotalGas(double totalGas) {
        this.totalGas = totalGas;
    }

    public void setTotalWater(double totalWater) {
        this.totalWater = totalWater;
    }

    public void setTotalElectricity(double totalElectricity) {
        this.totalElectricity = totalElectricity;
    }

    public double getTotalGas() {
        return totalGas;
    }

    public double getTotalWater() {
        return totalWater;
    }

    public double getTotalElectricity() {
        return totalElectricity;
    }

    public void calculate(double time) {}

    public int getTimeUsage() {return timeUsage;}

    public void setTimeUsage(int timeUsage) {this.timeUsage = timeUsage;}

    public boolean isUsed() {return used;}

    public void setUsed(boolean used) {this.used = used;}

    public void setEndTime(double endTime) {
        this.endTime = endTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
