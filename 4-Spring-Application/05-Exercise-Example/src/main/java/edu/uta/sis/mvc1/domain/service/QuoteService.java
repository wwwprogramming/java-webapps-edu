package edu.uta.sis.mvc1.domain.service;

import edu.uta.sis.mvc1.domain.data.Quote;

import java.util.List;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
public interface QuoteService {

    public List<Quote> getQuotes();

    public Quote get(Integer id);

    public void update(Quote q);

    public Quote remove(Quote q);

    public void create(Quote q);
}
