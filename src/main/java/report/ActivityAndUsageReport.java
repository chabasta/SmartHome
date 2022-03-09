package report;

import events.Activity;
import house.House;
import resident.Resident;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class ActivityAndUsageReport implements Report {

    private final House house;

    public ActivityAndUsageReport(House house) {
        this.house = house;
    }

    /**
     * report generator
     */
    @Override
    public void generateReport() {
        List<Activity> activities = new ArrayList<>();

        for (Resident resident : house.getAllResidents()) {
            activities.addAll(resident.getActivities());
        }

        try{
            File file = new File("src/main/java/ReportsFiles/ActivityReport.txt");

            // creates the file
            file.createNewFile();

            FileWriter ActivityReport = new FileWriter(file);

            ActivityReport.write("---------------------------------\n");
            ActivityReport.write("|   Activity and Usage Report   |\n");
            ActivityReport.write("---------------------------------\n");
            Map<String, List<Activity>> byResident =
                    activities.stream()
                            .collect(groupingBy((a -> a.getResident().toString())));

            byResident.forEach((String resident, List<Activity> activities1) ->
            {
                try {
                    ActivityReport.write("\n"+resident + ":\n\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Map<String, List<Activity>> byFirstArg = activities1.stream()
                        .collect(groupingBy(a -> a.getFirstArg()));

                byFirstArg.forEach((String firstArg, List<Activity> activities2) ->
                {
                    try {
                        ActivityReport.write(firstArg + " " + activities2.size() + "x\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Map<String, List<Activity>> bySecondArg =
                            activities2.stream().collect(groupingBy(a -> {
                                if (a.getSecondArg() == null) {
                                    return "none";
                                }
                                return a.getSecondArg();
                            }));
                    bySecondArg.forEach((String secondArg, List<Activity> activities3) ->
                    {
                        if (!secondArg.equals("none")) {
                            try {
                                ActivityReport.write("  -> " + secondArg + " " + activities3.size() + "x\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                });
            });

            ActivityReport.flush();
            ActivityReport.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }
}
