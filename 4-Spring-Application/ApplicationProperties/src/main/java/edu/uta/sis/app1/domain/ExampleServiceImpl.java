package edu.uta.sis.app1.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Hannu Lohtander on 2.4.2016.
 */
public class ExampleServiceImpl implements ExampleService {

    @Value("${example.1}")
    String exampleValue1;


    String exampleValue2;

    @Value("${catalina.base}")
    String exampleValue3;

    public void setExampleValue2(String value){
        this.exampleValue2 = value;
    }

    public String getExampleValue1() {
        return exampleValue1;
    }

    public String getExampleValue2() {
        return exampleValue2;
    }

    public String getExampleValue3() {
        return exampleValue3;
    }

}
