package edu.uta.courses.service.impl;

import edu.uta.courses.repository.QuizRepository;
import edu.uta.courses.repository.domain.Quiz;
import edu.uta.courses.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by me on 27.1.2015.
 */
@Service("quizService")
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Value("${my.test}")
    String myQuizServiceTestValue;


    @Override
    public Integer getRandomNumber() {
        // http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java

        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt(9) + 1;

        return randomNum;
    }

    @Override
    public Integer getMultiplication(Integer rand1, Integer rand2) {
        return rand1 * rand2;
    }

    @Override
    public void storeQuiz(Quiz quiz) {
        quizRepository.store(quiz);
    }

    @Override
    public Quiz getQuiz(Integer id) {
        return quizRepository.find(id);
    }

    @Override
    public List<Quiz> getQuizes() {
        try {
            return quizRepository.getQuizes();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Quiz>();
        }

    }
}
