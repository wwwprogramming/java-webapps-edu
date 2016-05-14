package edu.uta.sis.spring.client;

import edu.uta.sis.spring.client.domain.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */

@Controller
public class SendJmsController {

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    MessageService messageService;

    @RequestMapping("/send/{message}")
    public String send(@PathVariable("message") String message) {
        String reply = messageService.send(message);
        System.out.println(reply);
        logger.info("Reply: " + reply);
        return "/send";
    }

}
