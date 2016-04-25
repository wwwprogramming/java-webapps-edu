package edu.uta.sis.mvc1.domain.repository;

import edu.uta.sis.mvc1.domain.data.Quote;

import java.util.List;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
public interface QuotesRepository {

    // just to create unique ids
    public int getCounter();

    public void add(Quote quote);

    public void update(Quote quote);

    public Quote find(Integer id);

    public Quote remove(Integer id);

    public List<Quote> findAll();


}
