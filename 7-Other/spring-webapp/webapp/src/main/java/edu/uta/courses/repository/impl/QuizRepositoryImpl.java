package edu.uta.courses.repository.impl;

import edu.uta.courses.repository.QuizRepository;
import edu.uta.courses.repository.domain.Quiz;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by me on 3.2.2015.
 */
@Repository("quizRepository")
public class QuizRepositoryImpl implements QuizRepository {

    Logger log = Logger.getLogger(QuizRepositoryImpl.class.getName());

    @PersistenceContext(name = "entityManager")
    EntityManager em;

    @Override
    public void store(Quiz quiz) {
        em.persist(quiz);
    }

    @Override
    public Quiz find(Integer id) {
        return em.find(Quiz.class, id);
    }

    @Override
    public void update(Quiz quiz) {
        em.merge(quiz);
    }

    @Override
    public void remove(Quiz quiz) {
        em.remove(quiz);
    }

    @Override
    public List<Quiz> getQuizes() {
        return em.createQuery("SELECT z FROM Quiz z", Quiz.class).getResultList();
    }
}
