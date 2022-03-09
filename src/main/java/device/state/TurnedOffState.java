package device.state;

import java.util.Random;

public class TurnedOffState extends State{

    @Override
    public void nextState(double time) {
        device.setStartTime(time);
        if(device.toString().matches("Ski|Bike") ){
            device.setState(new InUseState());
        }
        else {
            Random rnd = new Random();
            int x = rnd.nextInt(2);
            if (x == 0) {
                device.setState(new ActiveState());
            } else {
                device.setState(new IdleState());
            }
            device.setState(new IdleState());
        }
    }

    @Override
    public String toString() {
        return "TurnedOffState";
    }
}
