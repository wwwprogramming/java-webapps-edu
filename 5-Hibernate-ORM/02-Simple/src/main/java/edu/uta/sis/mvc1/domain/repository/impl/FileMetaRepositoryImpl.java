package edu.uta.sis.mvc1.domain.repository.impl;

import edu.uta.sis.mvc1.domain.entities.FileMetaData;
import edu.uta.sis.mvc1.domain.repository.FileMetaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    public FileMetaData createMetaDate(String origName, String newName, long size) {

        FileMetaData metaData = new FileMetaData();
        metaData.setOriginalName(origName);
        metaData.setNewName(newName);
        metaData.setSize(-1);
        em.persist(metaData);
        return metaData;
    }


    public List<FileMetaData> getList() {
        List<FileMetaData> metaDatas = em.createQuery("FROM FileMetaData fmd").getResultList();
        return metaDatas;
    }
}
