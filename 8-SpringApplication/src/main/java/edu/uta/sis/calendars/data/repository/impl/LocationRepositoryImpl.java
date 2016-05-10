package edu.uta.sis.calendars.data.repository.impl;

import edu.uta.sis.calendars.data.entities.LocationEntity;
import edu.uta.sis.calendars.data.repository.LocationRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */
@Repository
@Transactional(readOnly = false)
public class LocationRepositoryImpl implements LocationRepository {

    @PersistenceContext
    EntityManager em;

    public void save(LocationEntity locationEntity)  {
        em.persist(locationEntity);
    }
}
