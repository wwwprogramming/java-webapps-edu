package edu.uta.sis.mvc1.domain.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Hannu Lohtander on 8.5.2016.
 */
@Component
public class FileCheckerProcess {

    @Scheduled(initialDelay=1000, fixedRate=5000)
    public void checkedScheduler() {
        System.out.println("Tadaa A");
    }

    @Scheduled(cron = "0 * * * * ?")
    public void sendNotifies() {
        System.out.println("Tadaa B");
    }
}
