package edu.uta.sis.mvc1.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Hannu Lohtander on 2.5.2016.
 */

@Entity
public class MyCategory {

    @Id
    @GeneratedValue
    Integer id;

    String name;



}
