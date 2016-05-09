package edu.uta.sis.calendars.data.repository.impl;



import edu.uta.sis.calendars.data.entities.FileMetaDataEntity;

import edu.uta.sis.calendars.data.entities.UserEntity;
import edu.uta.sis.calendars.data.repository.FileMetaRepository;
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

    // Transaction started at the service @Transactional(readOnly = false)
    public FileMetaDataEntity createMetaData(String origName, String newName, long size, UserEntity user) {

        FileMetaDataEntity metaData = new FileMetaDataEntity();
        metaData.setOriginalName(origName);
        metaData.setNewName(newName);
        metaData.setSize(-1);
        metaData.setUser(user);
        em.persist(metaData);

        return metaData;
    }


    public List<FileMetaDataEntity> getList() {
        List<FileMetaDataEntity> metaDatas = em.createQuery("FROM FileMetaDataEntity fmd").getResultList();
        return metaDatas;
    }
}
