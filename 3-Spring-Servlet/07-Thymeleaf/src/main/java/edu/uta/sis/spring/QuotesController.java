package edu.uta.sis.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannu Lohtander on 23.4.2016.
 */
@Controller
@RequestMapping("/th")
public class QuotesController {

    private List<Quote> dummyQuotes() {
        ArrayList<Quote> quotes = new ArrayList<Quote>();
        quotes.add(new Quote(1, "What ever 1", 2012, "John Doe"));
        quotes.add(new Quote(2, "What ever 2", 2013, "Jane Doe"));
        quotes.add(new Quote(3, "What ever 3", 2014, "Mary Doe"));
        quotes.add(new Quote(4, "What ever 4", 2015, "Mark Doe"));
        return quotes;
    }

    @RequestMapping(value = {"","/","home"},method = RequestMethod.GET)
    public String home(Model model) {
        // create 4 dummy quotes

        model.addAttribute("quotes", dummyQuotes());
        return "/thyme/index";
    }

    @RequestMapping(value="/create",method = RequestMethod.GET)
    public String create() {

        return "/thyme/create";
    }

    @RequestMapping(value="/read/{id}",method = RequestMethod.GET)
    public String read(@PathVariable("id") Integer id, Model model) {
        Quote quote = dummyQuotes().get(id -1);
        model.addAttribute("quote", quote);
        return "/thyme/read";
    }

    @RequestMapping(value="/update/{id}",method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id, Model model) {
        Quote quote = dummyQuotes().get(id -1);
        model.addAttribute("quote", quote);
        return "/thyme/update";
    }

    @RequestMapping(value="/update/{id}",method = RequestMethod.POST)
    public String update2(@PathVariable("id") Integer id, @ModelAttribute("quote") Quote quote, Model model) {
        // TODO UPDATE

        //model.addAttribute("quote", quote);
        return "/thyme/update";
    }

    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") Integer id, Model model) {
        Quote quote = dummyQuotes().get(id -1);
        model.addAttribute("quote", quote);
        return "/thyme/delete";
    }




}
