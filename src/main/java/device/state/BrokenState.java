package device.state;

public class BrokenState extends State{
    @Override
    public void nextState(double time) {
        device.setEndTime(time);
        device.setState(new TurnedOffState());
    }

    @Override
    public String toString() {
        return "BrokenState";
    }
}
