package edu.uta.sis.spring.tietokanta.impl;


import edu.uta.sis.spring.tietokanta.FileMetaRepository;
import edu.uta.sis.spring.tietokanta.entiteetit.FileMetaData;
import edu.uta.sis.spring.tietokanta.entiteetit.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Hannu Lohtander on 4.4.2016.
 */
@Repository
public class FileMetaRepositoryImpl implements FileMetaRepository {

    @PersistenceContext
    EntityManager em;

    public FileMetaData createMetaDate(String origName, String newName, long size, User user) {

        FileMetaData metaData = new FileMetaData();
        metaData.setOriginalName(origName);
        metaData.setNewName(newName);
        metaData.setSize(-1);
        metaData.setUser(user);
        em.persist(metaData);
        return metaData;
    }


    public List<FileMetaData> getList() {
        List<FileMetaData> metaDatas = em.createQuery("FROM FileMetaData fmd").getResultList();
        return metaDatas;
    }
}
