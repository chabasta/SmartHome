package report;

import device.Device;
import house.Floor;
import house.House;
import house.Room;
import resident.Resident;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HouseConfigurationReport implements Report {

    private House house;

    public HouseConfigurationReport(House house) {
        this.house = house;
    }

    /**
     * report generator
     */
    @Override
    public void generateReport() {
        try{
            File file = new File("src/main/java/ReportsFiles/HouseConfigurationReport.txt");

            // creates the file
            file.createNewFile();

            FileWriter HouseConfig = new FileWriter(file);
            HouseConfig.write("House\n");
            for (Floor floor : house.getFloors()) {
                HouseConfig.write( " |-> " + floor.toString()+"\n");
                for (Room room : floor.getRooms()) {
                    HouseConfig.write("  |--> " +room.toString()+"\n");
                    HouseConfig.write("    |----> Devices:\n");
                    for (Device device : room.getDevices()) {
                        HouseConfig.write("           •" + device.getName()+"\n");
                    }
                    HouseConfig.write("    |----> Residents:\n");
                    for (Resident resident : room.getResidents()) {
                        HouseConfig.write("           •" + resident.toString()+"\n");
                    }
                }
            }
            HouseConfig.flush();
            HouseConfig.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
