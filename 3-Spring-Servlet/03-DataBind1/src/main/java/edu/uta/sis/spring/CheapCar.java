package edu.uta.sis.spring;

/**
 * Created by Hannu Lohtander on 3.3.2016.
 */
public class CheapCar {

    public String model;

    public String code = "777";

    public CheapCar() {}

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
