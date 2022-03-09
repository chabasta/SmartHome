package report;

import events.Event;
import events.EventHistory;
import house.House;
import resident.Resident;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class EventReport implements Report{

    private final House house;

    public EventReport(House house) {
        this.house = house;
    }


    /**
     * report generator
     */
    @Override
    public void generateReport() {
        try{
            File file = new File("src/main/java/ReportsFiles/EventsReport.txt");

            // creates the file
            file.createNewFile();

            FileWriter EventsReport = new FileWriter(file);
            EventsReport.write("---------------------------------\n");
            EventsReport.write("|         Events Report         |\n");
            EventsReport.write("---------------------------------\n");

            Map<String, List<Event>> events = EventHistory.finishedEvents.stream()
                    .collect(groupingBy(Event::getType));

            events.forEach((String type, List<Event> events1) ->
            {
                try {
                    EventsReport.write(type + " " + events1.size() + "x\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Map<Resident, List<Event>> eventsByResident = events1.stream()
                        .collect(groupingBy(Event::getResident));
                eventsByResident.forEach((Resident resident, List<Event> events2) -> {
                            try {
                                EventsReport.write("  -> " + resident.toString() + " " + events2.size() + "x\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
            });
            EventsReport.flush();
            EventsReport.close();
        }catch (
                IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



    }
}
