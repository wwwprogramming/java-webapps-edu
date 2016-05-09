package edu.uta.sis.calendars.data.repository.impl;

import edu.uta.sis.calendars.data.entities.UserEntity;
import edu.uta.sis.calendars.data.repository.UserRepository;

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

    public UserEntity getUser(Integer id) {
        return em.find(UserEntity.class, id);
    }

    public UserEntity getUser(String username) {
        return em.createQuery("FROM UserEntity u WHERE u.username=:username", UserEntity.class).setParameter("username",username).getSingleResult();
    }

    public List<UserEntity> getUsers() {
        return em.createQuery("FROM UserEntity u", UserEntity.class).getResultList();
    }

    public void store(UserEntity u) {
        em.persist(u);
    }

    public void update(UserEntity u) {
        em.merge(u);
    }

    public void remove(Integer id) {
        UserEntity ue = getUser(id);
        em.remove(ue);
    }
}
