package edu.uta.sis.spring.editors;

import edu.uta.sis.spring.types.Color;

import java.beans.PropertyEditorSupport;

/**
 * Created by Hannu Lohtander on 15.4.2016.
 */
public class ColorEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // assume that is valid number
        Integer i = new Integer(text);
        Color.Colors color = Color.Colors.values()[i];
        setValue(new Color(color));
    }
}
