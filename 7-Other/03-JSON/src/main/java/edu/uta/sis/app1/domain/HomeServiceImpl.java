package edu.uta.sis.app1.domain;

import org.springframework.stereotype.Service;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */
@Service
public class HomeServiceImpl implements HomeService {

    public String getHello() {
        return "Hell01";
    }

    public String getHello2() {
        return "Hell02";
    }

}
