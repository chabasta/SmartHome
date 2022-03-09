package device.state;

public class IdleState extends State {

    @Override
    public void nextState(double time) {
        device.setStartTime(time);
        device.calculate(time);
        device.setState(new ActiveState());
    }

    @Override
    public String toString() {
        return "IdleState";
    }
}
