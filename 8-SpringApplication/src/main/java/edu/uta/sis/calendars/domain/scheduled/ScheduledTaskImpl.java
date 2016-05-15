package edu.uta.sis.calendars.domain.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */
@Component
public class ScheduledTaskImpl implements ScheduledTasks {

    @Scheduled(initialDelay=1000, fixedRate=360000)
    public void runForrestRun() {
        System.out.println("Climbing to the tree");
    }
}
