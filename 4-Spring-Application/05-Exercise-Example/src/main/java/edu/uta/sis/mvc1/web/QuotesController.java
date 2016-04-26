package edu.uta.sis.mvc1.web;

import edu.uta.sis.mvc1.domain.data.Quote;
import edu.uta.sis.mvc1.domain.service.QuoteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@Controller
public class QuotesController {

    Logger logger = Logger.getLogger(this.getClass().getName());


    @Autowired
    QuoteService quoteService;

    @InitBinder
    public void initBInder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/quotes/list")
    public String list(Model model) {
        logger.debug("List Quotes");

        model.addAttribute("quotes", quoteService.getQuotes());
        return "/quotes/list";
    }

    @RequestMapping(value = "/quotes/create", method = RequestMethod.GET)
    public String create(Model model) {
        logger.debug("Createt Quote");

        // just adding empty quote, so quote.id in the jsp exist, even though is null
        model.addAttribute("quote", new Quote());
        return "/quotes/form";
    }

    @RequestMapping(value = "/quotes/create", method = RequestMethod.POST)
    public String create(Model model, @Valid @ModelAttribute("quote") Quote q, BindingResult bindingResult) {
        logger.debug("Createt Quote");
        if (bindingResult.hasErrors()) {
            return "/quotes/form";
        }
        quoteService.create(q);
        // just adding empty quote, so quote.id in the jsp exist, even though is null
        model.addAttribute("quote", q);
        return "redirect:/quotes/list";
    }

    @RequestMapping(value = "/quotes/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id, Model model) {
        logger.debug("UPDATE Quote " + id);
        Quote q = quoteService.get(id);
        model.addAttribute("quote",q);
        return "/quotes/form";
    }

    @RequestMapping(value = "/quotes/update/{id}", method = RequestMethod.POST)
    public String update(@PathVariable("id") Integer id, Model model, @Valid @ModelAttribute("quote") Quote q, BindingResult bindingResult) {
        logger.debug("UPDATE Quote " + id);
        if (bindingResult.hasErrors()) {
            return "/quotes/form";
        }
        q.setId(id);
        quoteService.update(q);

        return "redirect:/quotes/list";
    }

    @RequestMapping(value = "/quotes/remove/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Integer id) {
        logger.debug("REMOVE Quote " + id);

        // Bit Stupid not to remove just by id but too lazy to fix this
        // FIXME use only id to remove
        quoteService.remove(quoteService.get(id));

        return "redirect:/quotes/list";
    }

    @RequestMapping(value = "/quotes/read/{id}", method = RequestMethod.GET)
    public String read(@PathVariable("id") Integer id, Model model) {
        logger.debug("READ Quote " + id);

        Quote quote = quoteService.get(id);
        model.addAttribute("quote", quote);

        return "/quotes/read";
    }

    // TODO OTHER METHODS create, read, update, delete

}
