package house;

import java.util.Iterator;
import java.util.List;

public class RoomIterator implements Iterator<Room> {

    private List<Floor> floorList;
    private int curFloorIndex = 0;
    private int curRoomIndex = 0;
    private boolean iterateOnce; //is there loop in iteration

    public RoomIterator(List<Floor> floorList, boolean iterateOnce) {
        this.floorList = floorList;
        this.iterateOnce = iterateOnce;
    }

    @Override
    public boolean hasNext() {
        if (iterateOnce) {
            return !floorList.isEmpty() && curFloorIndex < floorList.size();
        }
        else {
            return !floorList.isEmpty();
        }
    }

    @Override
    public Room next() {
        List<Room> roomsList = floorList.get(curFloorIndex).getRooms();
        Room roomToReturn = roomsList.get(curRoomIndex);
        curRoomIndex += 1;
        if (curRoomIndex >= roomsList.size()) {
            curFloorIndex += 1;
            curRoomIndex = 0;
            if (!iterateOnce && curFloorIndex == floorList.size()) {
                curFloorIndex = 0;
            }
        }
        return roomToReturn;
    }
}

