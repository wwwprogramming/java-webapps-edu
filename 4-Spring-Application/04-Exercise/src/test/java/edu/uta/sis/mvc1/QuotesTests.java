package edu.uta.sis.mvc1;

import edu.uta.sis.mvc1.domain.data.Quote;
import edu.uta.sis.mvc1.domain.repository.QuotesRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:**/root.xml"})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class QuotesTests {

    @Autowired
    protected QuotesRepository quotesRepository;

    @Test
    public void AAtestAddQuote() {

        Assert.assertEquals(4, quotesRepository.findAll().size());
        System.out.println("test o passed");
        System.out.println(quotesRepository.findAll().size());
    }

    @Test
    public void ABtestAddQuote() {
        quotesRepository.add(new Quote(quotesRepository.getCounter() +1, "A1",1111,"Hannu"));
        Assert.assertEquals(5, quotesRepository.find(5).getId().intValue());
        System.out.println("test 1 passed");
        System.out.println(quotesRepository.findAll().size());
    }

    @Test
    public void ACtestRemoveQuote() {
        quotesRepository.remove(1);
        Assert.assertEquals(4, quotesRepository.findAll().size());
        System.out.println("test 2 passed");
    }

    @Test
    public void ADtestUpdateQuote() {
        Quote q = quotesRepository.find(2);
        q.setYear(2016);
        quotesRepository.update(q);
        Assert.assertEquals(2016, quotesRepository.find(2).getYear().intValue());
        System.out.println("test 3 passed");
    }

    @Test
    public void EEtestUpdateQuote() {
        Quote q = quotesRepository.find(3);
        Assert.assertEquals("What ever 3", q.getQuote());
        System.out.println("test 4 passed");
    }

    @Test
    public void FFtestAddQuote() {
        quotesRepository.add(new Quote(quotesRepository.getCounter() +1, "AX",2221,"Minna"));
        Assert.assertEquals("AX", quotesRepository.find(quotesRepository.getCounter()).getQuote());
        System.out.println("test 5 passed");
        System.out.println(quotesRepository.findAll().size());
    }





}
