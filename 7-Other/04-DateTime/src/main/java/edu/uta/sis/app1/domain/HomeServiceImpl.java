package edu.uta.sis.app1.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Hannu Lohtander on 28.3.2016.
 */
@Service
public class HomeServiceImpl implements HomeService {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void save(TestEntity testEntity) {
        em.persist(testEntity);
    }

}
