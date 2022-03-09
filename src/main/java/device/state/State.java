package device.state;

import device.Device;

public abstract class State {

    protected Device device;

    public void setDevice(Device device){
        this.device = device;
    }
    public abstract void nextState(double time);

}
