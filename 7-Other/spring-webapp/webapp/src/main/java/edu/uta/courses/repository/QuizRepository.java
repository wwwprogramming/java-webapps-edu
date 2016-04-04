package edu.uta.courses.repository;

import edu.uta.courses.repository.domain.Quiz;

import java.util.List;

/**
 * Created by me on 3.2.2015.
 */


public interface QuizRepository {

    public void store(Quiz quiz);

    public Quiz find(Integer id);

    public void update(Quiz quiz);

    public void remove(Quiz quiz);

    public List<Quiz> getQuizes();


}
