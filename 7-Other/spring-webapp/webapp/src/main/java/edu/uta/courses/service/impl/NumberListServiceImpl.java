package edu.uta.courses.service.impl;

import edu.uta.courses.service.NumberListService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by me on 27.1.2015.
 */
@Service("numberListService")
public class NumberListServiceImpl implements NumberListService {

    @Override
    public void orderNumberList(ArrayList<String> list) {
        // http://beginnersbook.com/2013/12/how-to-sort-arraylist-in-java/
        Collections.sort(list);
    }
}
