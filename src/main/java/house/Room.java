package house;

import device.Device;
import resident.Resident;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private String name;
    private List<Device> devices = new ArrayList<>();
    private List<Resident> residents = new ArrayList<>();
    private List<Window> windows = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        this.devices.add(device);
    }

    public void addDevice(Device... devices) {
        for (Device device : devices) {
            addDevice(device);
        }
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void addResident(Resident resident) {
        this.residents.add(resident);
    }

    public void addResident(Resident... residents) {
        for (Resident resident: residents) {
            addResident(resident);
        }
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void addWindow(Window window) {
        this.windows.add(window);
    }

    public void addWindow(Window... windows) {
        for (Window window: windows) {
            addWindow(window);
        }
    }

    @Override
    public String toString() {
        return name ;
    }
}
