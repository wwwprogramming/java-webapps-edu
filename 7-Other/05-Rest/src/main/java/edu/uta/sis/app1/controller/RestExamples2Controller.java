package edu.uta.sis.app1.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hannu Lohtander on 14.4.2016.
 */
@RestController
public class RestExamples2Controller {

    @RequestMapping("/rest4")
    public FastCar rest4() {
        FastCar fastCar = new FastCar();
        fastCar.setSpeed(250);
        fastCar.setColor("BLUE");
        return fastCar;
    }

    @RequestMapping(value = "/rest5", consumes = "application/json")
    public FastCar rest5(@RequestBody FastCar fastCar) {
        System.out.println(fastCar);
        fastCar.setSpeed(fastCar.getSpeed() + 100);
        return fastCar;
    }

}
