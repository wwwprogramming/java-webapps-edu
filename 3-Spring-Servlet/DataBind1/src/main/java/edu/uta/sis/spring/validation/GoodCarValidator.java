package edu.uta.sis.spring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Hannu Lohtander on 3.3.2016.
 */
public class GoodCarValidator implements ConstraintValidator<GoodCar,String> {


    @Override
    public void initialize(GoodCar constraintAnnotation) {
         // any attribute of the annotation instance is available here
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;
        if (!value.equals("ferrari") && !value.equals("bugatti")) return false;
        return true;
    }
}
