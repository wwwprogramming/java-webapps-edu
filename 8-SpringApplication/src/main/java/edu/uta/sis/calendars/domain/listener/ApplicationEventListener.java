package edu.uta.sis.calendars.domain.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@Component
public class ApplicationEventListener {

    @Value("${catalina.base}")
    String catalinaBase;

    @Value("${files.upload.dir}")
    String uploadDir;

    Integer count=0;

    @EventListener({ContextRefreshedEvent.class})
    void contextRefreshedEvent(ContextRefreshedEvent event) {
        if (count > 0) return;
        count++;

        System.out.println("a context refreshed event happened");
        // if there is no uploads path, create one.
       // Resource pathResource = new FileSystemResource(catalinaBase);
        Resource uploadPathResource = new FileSystemResource(uploadDir);


        if (!uploadPathResource.exists()) {
            try {
                uploadPathResource.getFile().mkdir();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            } finally {
                // close?
            }

        }
    }

}
