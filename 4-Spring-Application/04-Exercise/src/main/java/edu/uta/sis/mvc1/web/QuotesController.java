package edu.uta.sis.mvc1.web;

import edu.uta.sis.mvc1.domain.service.QuoteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@Controller
public class QuotesController {

    Logger logger = Logger.getLogger(this.getClass().getName());


    @Autowired
    QuoteService quoteService;

    @RequestMapping("/quotes/list")
    public String list(Model model) {
        logger.debug("List Quotes");

        model.addAttribute("quotes", quoteService.getQuotes());
        return "/quotes/list";
    }

    // TODO OTHER METHODS create, read, update, delete

}
