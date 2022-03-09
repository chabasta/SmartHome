package report;

import device.Device;
import house.House;
import house.Room;
import house.RoomIterator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsumptionReport implements Report {

    private List<Device> allDevices = new ArrayList<>();
    private double totalElectricity;
    private double totalWater;
    private double totalGas;

    public ConsumptionReport(House house) {
        RoomIterator roomIterator = new RoomIterator(house.getFloors(), true);
        while (roomIterator.hasNext()) {
            Room room = roomIterator.next();
            allDevices.addAll(room.getDevices());
        }
    }
    /**
     * report generator
     */
    @Override
    public void generateReport() {
        try{
            File file = new File("src/main/java/ReportsFiles/ConsumptionReport.txt");

            // creates the file
            file.createNewFile();

            FileWriter HouseConfig = new FileWriter(file);

            for (Device device : allDevices) {
                HouseConfig.write(device.getName() + " Electricity: " + device.getTotalElectricity() + " , water: " + device.getTotalWater() + " , gas: " + device.getTotalGas()+"\n");
                totalElectricity += device.getTotalElectricity();
                totalWater += device.getTotalWater();
                totalGas += device.getTotalGas();
            }
            HouseConfig.write("Total electricity: " + totalElectricity + " , water: " + totalWater + " , gas: " + totalGas+"\n");

            HouseConfig.flush();
            HouseConfig.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
