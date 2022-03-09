package house;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private String name;
    private List<Room> rooms = new ArrayList<Room>();

    public Floor(String name) {
        this.name = name;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    @Override
    public String toString() {
        return name;
    }
}


