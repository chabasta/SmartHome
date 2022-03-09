package house;

import device.Device;
import events.EventHistory;
import resident.Resident;

import java.util.ArrayList;
import java.util.List;

public class House {

    private List<Floor>     floors;
    private List<Room>      allRooms;
    private List<Device>    allDevices;
    private List<Resident>  allResidents;
    private List<Window>    allWindows;
    private List<Blinds>    allBlinds;

    private EventHistory eventHistory;

    public House(HouseBuilder houseBuilder) {
        this.floors = houseBuilder.floors;
        this.allRooms = houseBuilder.allRooms;
        this.allDevices = houseBuilder.allDevices;
        this.allResidents = houseBuilder.allResidents;
        this.allWindows = houseBuilder.allWindows;
        this.allBlinds = houseBuilder.allBlinds;
    }

    public EventHistory getEventHistory() {
        return eventHistory;
    }

    public void setEventHistory(EventHistory eventHistory) {
        this.eventHistory = eventHistory;
    }

    /**
     * collects all information about the house
     */
    public void getInfo() {
        RoomIterator roomIterator = new RoomIterator(floors, true);
        while (roomIterator.hasNext()) {
            Room room = roomIterator.next();
            allDevices.addAll(room.getDevices());
            allResidents.addAll(room.getResidents());
            allWindows.addAll(room.getWindows());
            allRooms.add(room);
        }
        for (Window window : allWindows) {
            allBlinds.add(window.getBlinds());
        }
    }

    public List<Device> getAllDevices() {
        return allDevices;
    }

    public List<Room> getAllRooms() {
        return allRooms;
    }

    public List<Resident> getAllResidents() {
        return allResidents;
    }

    public List<Window> getAllWindows() {
        return allWindows;
    }

    public List<Blinds> getAllBlinds() {
        return allBlinds;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    /**
     * house builder
     */
    public static class HouseBuilder
    {
        private List<Floor>     floors       = new ArrayList<>();
        private List<Room>      allRooms     = new ArrayList<>();
        private List<Device>    allDevices   = new ArrayList<>();
        private List<Resident>  allResidents = new ArrayList<>();
        private List<Window>    allWindows   = new ArrayList<>();
        private List<Blinds>    allBlinds    = new ArrayList<>();

        public HouseBuilder() {
        }

        public HouseBuilder addFloor(String name) {
            this.floors.add(new Floor(name));
            return this;
        }

        public HouseBuilder addRoom(String floor, String... rooms) {
            for(Floor fl: floors){
                if (fl.toString().equals(floor)){
                    for (String room : rooms){
                        fl.addRoom(new Room(room));
                    }
                }
            }
            return this;
        }
        //Return the finally consrcuted House object
        public House build() {
            return new House(this);
        }
    }

}
