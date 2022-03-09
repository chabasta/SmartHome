import device.Device;
import house.House;
import house.HouseFactory;
import report.ActivityAndUsageReport;
import report.ConsumptionReport;
import report.EventReport;
import report.HouseConfigurationReport;
import resident.ResidentApi;
import utils.Timer;


public class SmartHome {

    public static void main(String[] args) {

//        House house = HouseFactory.createSmallHouse(); //configuration for smal house

        House house = HouseFactory.createMediumHouse(); //configuration for medium house

//        House house = HouseFactory.createBigHouse(); //configuration for big house

        house.getInfo();
        ResidentApi residentApi = new ResidentApi(house.getAllResidents());
        Timer timer = new Timer(12,30, residentApi, house.getAllBlinds());
        int hoursToProcess = 25;

        for (int i = 0; i < hoursToProcess * 60; i++) {
            timer.increaseTime(1);
        }

        for (Device device : house.getAllDevices()) {
            device.stop(timer.getTime());
        }

        HouseConfigurationReport houseReport = new HouseConfigurationReport(house);
        EventReport eventReport = new EventReport(house);
        ActivityAndUsageReport activityAndUsageReport = new ActivityAndUsageReport(house);
        ConsumptionReport consumptionReport = new ConsumptionReport(house);


        consumptionReport.generateReport();
        houseReport.generateReport();
        activityAndUsageReport.generateReport();
        eventReport.generateReport();
    }
}
