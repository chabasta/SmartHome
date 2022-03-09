package device;

import device.devices.*;
import java.util.Random;

public class DeviceFactory {

    private static DeviceFactory instanceDeviceFactory = null;

    private DeviceFactory(){}

    public DeviceFactory getInstance(){
        if (instanceDeviceFactory == null) {
            instanceDeviceFactory = new DeviceFactory();
        }
        return instanceDeviceFactory;
    }
    Random random = new Random();

    /**
     * The function returns an instance of the class device generate a name with a serial code
     * @return instance of class device
     */
    public static Device createRandomDevice(){
        Random rnd = new Random();
        switch (rnd.nextInt(14)) {
            case 0 -> {
                return new Toilet("Toilet_"+rnd.nextInt(100));
            }
            case 1 -> {
                return new TV("TV_"+rnd.nextInt(100));
            }
            case 2 -> {
                return new Radio("Radio_"+rnd.nextInt(100));
            }
            case 3 -> {
                return new Sink("Sink_"+rnd.nextInt(100));
            }
            case 4 -> {
                return new Fireplace("Fireplace_"+rnd.nextInt(100));
            }
            case 5 -> {
                return new Stove("Stove_"+rnd.nextInt(100));
            }
            case 6 -> {
                return new PC("PC_"+rnd.nextInt(100));
            }
            case 7 -> {
                return new DishWash("DishWash_"+rnd.nextInt(100));
            }
            case 8 -> {
                return new Fridge("Fridge_"+rnd.nextInt(100));
            }
            case 9 -> {
                return new Phone("Phone_"+rnd.nextInt(100));
            }
            case 10 -> {
                return new Treadmill("Treadmill_"+rnd.nextInt(100));
            }
            case 11 -> {
                return new WashMachine("WashMachine_"+rnd.nextInt(100));
            }
            case 12 -> {
                return new Bike("Bike_"+rnd.nextInt(100));
            }
            case 13 -> {
                return new Ski("Ski_"+rnd.nextInt(100));
            }
            default -> {
                return null;
            }
            }
    }
}
