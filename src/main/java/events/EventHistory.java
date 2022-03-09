package events;

import java.util.ArrayList;
import java.util.List;

public class EventHistory {

    public static List<Event> eventsToDo = new ArrayList<>();
    public static List<Event> finishedEvents = new ArrayList<>();

    public void addToEventsToDo(Event event) {
        eventsToDo.add(event);
    }

    public void addToFinishedEvents(Event event) {
        eventsToDo.remove(event);
        finishedEvents.add(event);
    }
}
