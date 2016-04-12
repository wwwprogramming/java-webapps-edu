package edu.uta.sis.i18n.domain;

import org.springframework.stereotype.Service;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */
@Service
public class HomeServiceImpl implements HomeService {

    public String getHello() {
        return "hello.01";
    }

    public String getHello2() {
        return "hello.02";
    }

}
