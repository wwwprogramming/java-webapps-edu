package edu.uta.sis.spring.editors;

import edu.uta.sis.spring.types.Age;

import java.beans.PropertyEditorSupport;

/**
 * Created by Hannu Lohtander on 15.4.2016.
 */
public class AgeEditor extends PropertyEditorSupport {


    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // assume that text is ten years old
        setValue(new Age(10));
    }
}
