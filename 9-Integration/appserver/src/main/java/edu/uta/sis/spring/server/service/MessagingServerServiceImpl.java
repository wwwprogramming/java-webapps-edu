package edu.uta.sis.spring.server.service;

import org.springframework.stereotype.Service;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */
@Service("messagingServer")
public class MessagingServerServiceImpl implements MessagingServerService {

    public String receive(String message) {
        System.out.println("OK OK OK OK OK OK " + message);
        return "OK";
    }
}
