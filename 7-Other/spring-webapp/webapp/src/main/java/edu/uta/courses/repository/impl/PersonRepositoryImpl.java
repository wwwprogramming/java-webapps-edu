package edu.uta.courses.repository.impl;

import edu.uta.courses.repository.PersonRepository;
import edu.uta.courses.repository.domain.User;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by me on 10.2.2015.
 */
@Repository("personRepository")
public class PersonRepositoryImpl implements PersonRepository {

    Logger log = Logger.getLogger(PersonRepositoryImpl.class.getName());


    @PersistenceContext(name = "entityManager")
    EntityManager em;

    @Override
    public void create(User user) {
        user.setCreatedOn(new DateTime());
        em.persist(user);
        if (log.isDebugEnabled()) log.debug("Persisted user");
    }

    @Override
    public void update(User user) {
        user.setModifiedOn(new DateTime());
        em.merge(user);
        if (log.isDebugEnabled()) log.debug("Merged user");
    }

    @Override
    public void delete(User user) {
        if (log.isDebugEnabled()) log.debug("Remove user ("+ user.getId() +")");
        User user2 = findById(user.getId());
        em.remove(user2);
        user.setId(null);
    }

    @Override
    public void archive(User user) {
        user.setModifiedOn(new DateTime());
        user.setArchivedOn(new DateTime());
        em.merge(user);
        if (log.isDebugEnabled()) log.debug("Archived user");
    }



    @Override
    public User findByUsername(String username) {
        if (log.isDebugEnabled()) log.debug("findByUsername(String '"+username+"')");
        Query q = em.createQuery("select u from User u where u.userName=?1", User.class);
        q.setParameter(1, username);
        return (User)q.getSingleResult();
    }

    @Override
    public User findByKey(String hashKey) {
        if (log.isDebugEnabled()) log.debug("findByKey(String '"+ hashKey +"')");
        Query q = em.createQuery("select u from User u where u.hashKey=?1", User.class);
        q.setParameter(1, hashKey);
        return (User)q.getSingleResult();
    }

    @Override
    public User findById(Long id) {
        if (log.isDebugEnabled()) log.debug("Find By Id: " + id);
        return em.find(User.class, id);
    }

    @Override
    public List<User> findActiveUsers() {
        if (log.isDebugEnabled()) log.debug("findActiveUsers");
        // user is employee in this company,
        // AND is not archived
        return em.createQuery("SELECT u FROM User u WHERE u.archivedOn IS NULL", User.class).getResultList();
    }

    @Override
    public List<User> findUsers() {
        if (log.isDebugEnabled()) log.debug("findUsers()");
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public Boolean existByUsername(String username) {
        if (log.isDebugEnabled()) log.debug("existByUsername(String "+username+")");
        Query q = em.createQuery("SELECT COUNT(u.id) from User u where u.userName=?1", Long.class);
        q.setParameter(1, username);
        long count = (Long)q.getSingleResult();
        if (count > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


}

