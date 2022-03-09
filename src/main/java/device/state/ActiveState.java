package device.state;


public class ActiveState extends State{
    @Override
    public void nextState(double time) {
        device.setEndTime(time);
        device.calculate(time);
        device.setState(new TurnedOffState());
    }

    @Override
    public String toString() {
        return "ActiveState";
    }
}
