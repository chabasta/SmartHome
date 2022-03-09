package house;

import device.DeviceFactory;
import events.EventHistory;
import resident.*;
import resident.humans.*;
import resident.pets.Cat;
import resident.pets.Dog;
import resident.pets.Penguin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class HouseFactory {

    private static HouseFactory instanceHouseFactory = null;
    private HouseFactory(){}

    public HouseFactory getInstance(){
        if (instanceHouseFactory == null) {
            instanceHouseFactory = new HouseFactory();
        }
        return instanceHouseFactory;
    }

    /**
     * build small house
     */
    public static House createSmallHouse() {
        House house = new House.HouseBuilder()
                .addFloor("First Floor")
                .addRoom("First Floor" ,"Kitchen", "Living Room", "Toilet Room", "Garage")
                .addFloor("Second Floor")
                .addRoom("Second Floor","Bedroom", "Bathroom", "KidsRoom").build();

        Random rand = new Random();

        int counter = 1;

        while(counter <= 10){
            for (Floor flr: house.getFloors()){
                int number = rand.nextInt(flr.getRooms().size());
                flr.getRooms().get(number).addDevice(DeviceFactory.createRandomDevice());
                counter++;
            }
        }

        house.setEventHistory(new EventHistory());
        List<Resident> residents = new ArrayList<>();
        residents.add(new Father    ("Homer", house));
        residents.add(new Mother    ("Marge", house));
        residents.add(new Son       ("Bart", house));
        residents.add(new Daughter  ("Lisa", house));
        residents.add(new Dog       ("Santa's Little Helper", house));
        residents.add(new Penguin   ("Linux", house));

        randomPlacement(residents, house); //residents =

        return house;
    }
    /**
     * build medium house
     */
    public static House createMediumHouse() {
        House house = new House.HouseBuilder()
                .addFloor("First Floor")
                .addRoom("First Floor" ,"Kitchen", "Living Room", "Toilet Room", "Garage")
                .addFloor("Second Floor")
                .addRoom("Second Floor","Bedroom", "Bathroom", "KidsRoom").build();

        Random rand = new Random();

        int counter = 1;

        while(counter <= 15){
            for (Floor flr: house.getFloors()){
                int number = rand.nextInt(flr.getRooms().size());
                flr.getRooms().get(number).addDevice(DeviceFactory.createRandomDevice());
                counter++;
            }
        }

        house.setEventHistory(new EventHistory());
        List<Resident> residents = new ArrayList<>();
        residents.add(new Father        ("Homer", house));
        residents.add(new Mother        ("Marge", house));
        residents.add(new GrandMother   ("Charlotte ",house));
        residents.add(new Son           ("Bart", house));
        residents.add(new Daughter      ("Lisa", house));
        residents.add(new Baby          ("Maggie", house));
        residents.add(new Dog           ("Santa's Little Helper", house));
        residents.add(new Cat           ("Snowball V", house));
        residents.add(new Penguin       ("Linux", house));

        randomPlacement(residents, house); //residents =

        return house;
    }

    /**
     * build big house
     */
    public static House createBigHouse() {
        House house = new House.HouseBuilder()
                .addFloor("First Floor")
                .addRoom("First Floor" ,"Kitchen", "Living Room", "Toilet Room", "Garage")
                .addFloor("Second Floor")
                .addRoom("Second Floor","Bedroom", "Bathroom", "KidsRoom").build();


        Random rand = new Random();

        int counter = 1;

        while(counter <= 25){
            for (Floor flr: house.getFloors()){
                int number = rand.nextInt(flr.getRooms().size());
                flr.getRooms().get(number).addDevice(DeviceFactory.createRandomDevice());
                counter++;
            }
        }

        house.setEventHistory(new EventHistory());
        List<Resident> residents = new ArrayList<>();
        residents.add(new Father        ("Homer", house));
        residents.add(new Mother        ("Marge", house));
        residents.add(new GrandMother   ("Charlotte ",house));
        residents.add(new Son           ("Bart", house));
        residents.add(new Daughter      ("Lisa", house));
        residents.add(new Baby          ("Maggie", house));
        residents.add(new Dog           ("Santa's Little Helper", house));
        residents.add(new Cat           ("Snowball V", house));
        residents.add(new Penguin       ("Linux", house));
        residents.add(new Aunt          ("Lila", house));
        residents.add(new GrandFather   ("Valera", house));
        residents.add(new Uncle         ("Roger", house));

        randomPlacement(residents, house); //residents =

        return house;
    }

    /**
     * random placement of strangers (with chance of placing = 33%)
     * @param residents
     * @param house
     */
    public static void randomPlacement(List<Resident> residents, House house){
        RoomIterator roomIterator = new RoomIterator(house.getFloors(), false);
        Random random = new Random();

        Collections.shuffle(residents);

        while (residents.size() != 0) {
            if (roomIterator.hasNext()) {
                Room roomToAddTo = roomIterator.next();
                if (random.nextInt(3) == 1) {
                    roomToAddTo.addResident(residents.get(0));
                    residents.get(0).setLocation(roomToAddTo);
                    residents.remove(residents.get(0));
                }
            }
        }
    }


}
