package device.state;

public class InUseState extends State{

    @Override
    public void nextState(double time) {
        device.setState(new TurnedOffState());
    }

    @Override
    public String toString() {
        return "InUseState";
    }
}
