package edu.uta.sis.app1.domain;

import org.springframework.stereotype.Service;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */

@Service
public class CalculatorServiceImpl implements CalculatorService {

    public Integer sum(Integer x, Integer y) {
        return x + y;
    }
}
