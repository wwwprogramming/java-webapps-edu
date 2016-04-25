package edu.uta.sis.mvc1.domain.repository.impl;

import edu.uta.sis.mvc1.domain.data.Quote;
import edu.uta.sis.mvc1.domain.repository.QuotesRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@Repository
public class QuotesRepositoryImpl implements QuotesRepository {

    private HashMap<Integer, Quote> quotes = new HashMap<Integer, Quote>();

    private int counter = 0;

    @PostConstruct
    public void initDummyData() {
        quotes.put(1,new Quote(1, "What ever 1", 2012, "John Doe"));
        quotes.put(2,new Quote(2, "What ever 2", 2013, "Jane Doe"));
        quotes.put(3,new Quote(3, "What ever 3", 2014, "Mary Doe"));
        quotes.put(4,new Quote(4, "What ever 4", 2015, "Mark Doe"));
        counter = 4;
    }

    public int getCounter() {return counter;}

    public void add(Quote quote) {
        counter++;
        quotes.put(quote.getId(), quote);
    }

    public void update(Quote quote) {
        // quotes are compared by their id
        for (Map.Entry<Integer, Quote> entry : quotes.entrySet()) {
            if (entry.getValue().getId().intValue() == quote.getId().intValue()) {
                quotes.put(entry.getKey(),quote);
                continue;
            }
        }

    }

    public Quote find(Integer id) {
        Quote quote = null;
        // by id, which should also be hashmap key but just to be sure iterate.
        for (Map.Entry<Integer, Quote> entry : quotes.entrySet()) {
            if (entry.getValue().getId().intValue() == id.intValue()) {
                quote = entry.getValue();
                continue;
            }
        }
        return quote;
    }

    public Quote remove(Integer id) {
        Quote quote = null;
        if (quotes.containsKey(id)) {
            quote = quotes.remove(id);
        }
        return quote;
    }

    public List<Quote> findAll() {
        // hashmap to list, is this necessary?
        List<Quote> list = new ArrayList<Quote>(quotes.values());
        return list;
    }
}
