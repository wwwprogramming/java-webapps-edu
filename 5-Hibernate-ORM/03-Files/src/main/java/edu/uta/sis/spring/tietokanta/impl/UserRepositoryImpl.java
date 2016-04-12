package edu.uta.sis.spring.tietokanta.impl;

import edu.uta.sis.spring.tietokanta.UserRepository;
import edu.uta.sis.spring.tietokanta.entiteetit.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Hannu Lohtander on 5.4.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    public User getUser(Integer id) {
        return em.find(User.class, id);
    }

    public User getUser(String username) {
        return em.createQuery("FROM User u WHERE u.username=:username", User.class).setParameter("username",username).getSingleResult();
    }

    public List<User> getUsers() {
        return (List<User>)em.createQuery("FROM User u").getResultList();
    }

    public void store(User u) {
        em.persist(u);
    }

    public void update(User u) {
        em.merge(u);
    }
}
