package edu.uta.sis.spring;



import edu.uta.sis.spring.validation.GoodCar;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created by Hannu Lohtander on 3.3.2016.
 */
public class BindValidateForm {

    @NotEmpty
    public String car;

    @GoodCar()
    @NotEmpty
    public String expensiveCar;

    @edu.uta.sis.spring.validation.CheapCar
    @NotNull
    public CheapCar cheapCar;

    @Digits(integer=11, fraction=0)
    public Integer numSold;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getExpensiveCar() {
        return expensiveCar;
    }

    public void setExpensiveCar(String expensiveCar) {
        this.expensiveCar = expensiveCar;
    }

    public CheapCar getCheapCar() {
        return cheapCar;
    }

    public void setCheapCar(CheapCar cheapCar) {
        this.cheapCar = cheapCar;
    }

    public Integer getNumSold() {
        return numSold;
    }

    public void setNumSold(Integer numSold) {
        this.numSold = numSold;
    }
}
