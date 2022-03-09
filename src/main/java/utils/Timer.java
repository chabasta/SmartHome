package utils;

import house.Blinds;
import resident.ResidentApi;

import java.util.List;

public class Timer {

    enum DayTime {
        MORNING, // 6:00 to 11:59 (360 to 719)
        NOON, // 12:00 to 17:00 (720 to 1020)
        EVENING, // 17:01 to 23:00 (1021 to 1380)
        NIGHT; // 23:01 to 5:59 (1381 to 1440, 0 to 359)
    }
    private double time = 0;
    private DayTime dayTime;

    private ResidentApi residentApi;
    private List<Blinds> blindsList;

    public Timer(int hour, int minutes, ResidentApi residentApi, List<Blinds> blindsList) {
        this.time = (hour * 60) + minutes;
        setDayTime(time);
        this.residentApi = residentApi;
        this.blindsList = blindsList;
    }

    public void increaseTime(double time) {
        this.time += time;
        if (this.time >= 1440) {
            this.time = this.time % 1440;
        }
        setDayTime(this.time);
        residentApi.updateResidents(this.time);
    }

    public void setDayTime(double time) {
        if (360 <= time && time <= 719) {
            dayTime = DayTime.MORNING;
        }
        else if (720 <= time && time <= 1020) {
            dayTime = DayTime.NOON;
        }
        else if (1021 <= time && time <= 1380) {
            dayTime = DayTime.EVENING;
        }
        else if ((1381 <= time && time <= 1440) || (0 <= time && time <= 359)) {
            dayTime = DayTime.NIGHT;
        }
    }

    public double getTime() {
        return time;
    }

    public DayTime getDayTime() {
        return dayTime;
    }
}
