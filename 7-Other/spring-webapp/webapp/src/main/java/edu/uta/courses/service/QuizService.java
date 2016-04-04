package edu.uta.courses.service;


import edu.uta.courses.repository.domain.Quiz;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by me on 27.1.2015.
 */
public interface QuizService {



    public Integer getRandomNumber();

    public Integer getMultiplication(Integer rand1, Integer rand2);

    @Transactional
    public void storeQuiz(Quiz quiz);

    @Transactional
    public Quiz getQuiz(Integer id);

    @Transactional
    public List<Quiz> getQuizes();

}
