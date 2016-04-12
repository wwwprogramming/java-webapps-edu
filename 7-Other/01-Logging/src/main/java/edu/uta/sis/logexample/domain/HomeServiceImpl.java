package edu.uta.sis.logexample.domain;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */
@Service
public class HomeServiceImpl implements HomeService {

    Logger logger = Logger.getLogger(HomeServiceImpl.class.getName());

    public String getHello() {
        logger.debug("Debug from getHello");
        logger.info("Info from getHello");

        return "Hell01";
    }

    public String getHello2() {
        logger.debug("Debug from getHello2");
        logger.info("Info from getHello2");
        return "Hell02";
    }

}
