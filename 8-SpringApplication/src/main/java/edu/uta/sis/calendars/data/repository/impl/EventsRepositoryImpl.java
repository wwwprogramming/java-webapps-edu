package edu.uta.sis.calendars.data.repository.impl;


import edu.uta.sis.calendars.data.entities.EventEntity;
import edu.uta.sis.calendars.data.repository.EventsRepository;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 * Created by Hannu Lohtander on 25.4.2016.
 */
@Repository
@Transactional(readOnly = false)
public class EventsRepositoryImpl implements EventsRepository {

    @PersistenceContext
    EntityManager em;



    public void add(EventEntity eventEntity) {
        em.persist(eventEntity);
    }

    public void update(EventEntity eventEntity) {
        em.merge(eventEntity);
    }

    public EventEntity find(Integer id) {
        return em.find(EventEntity.class, id);
    }

    public EventEntity remove(Integer id) {
        EventEntity eventEntity = find(id);
        em.remove(eventEntity);
        return eventEntity;
    }

    public List<EventEntity> findAll() {
        return em.createQuery("From EventEntity e", EventEntity.class).getResultList();
    }

    public List<EventEntity> search(DateTime start, DateTime end) {
        try {
            return em.createQuery("From EventEntity e WHERE e.start >= :start AND e.end <= :end", EventEntity.class)
                    .setParameter("start", start)
                    .setParameter("end", end)
                    .setFirstResult(0)
                    .setMaxResults(20)
                    .getResultList();
        } catch (NoResultException nre) {
            /* no-op */
            return new ArrayList<EventEntity>();
        }
    }
}
