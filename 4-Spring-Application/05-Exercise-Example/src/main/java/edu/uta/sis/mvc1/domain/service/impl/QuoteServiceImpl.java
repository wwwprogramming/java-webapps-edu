package edu.uta.sis.mvc1.domain.service.impl;

import edu.uta.sis.mvc1.domain.data.Quote;
import edu.uta.sis.mvc1.domain.repository.QuotesRepository;
import edu.uta.sis.mvc1.domain.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@Service
public class QuoteServiceImpl implements QuoteService {


    @Autowired
    QuotesRepository quotesRepository;

    public List<Quote> getQuotes() {
        return quotesRepository.findAll();
    }

    public Quote get(Integer id) {
        return quotesRepository.find(id);
    }

    public void update(Quote q) {
        quotesRepository.update(q);
    }

    public Quote remove(Quote q) {
        return quotesRepository.remove(q.getId());
    }

    public void create(Quote q) {
        // STUPID WAY TO CREATE IDs. BUT THIS IS JUST DEMO CODE.
        q.setId(quotesRepository.getCounter() +1);
        quotesRepository.add(q);
    }
}
