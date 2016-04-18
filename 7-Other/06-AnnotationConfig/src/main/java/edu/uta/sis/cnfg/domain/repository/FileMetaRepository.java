package edu.uta.sis.cnfg.domain.repository;

import edu.uta.sis.cnfg.domain.entities.FileMetaData;

import java.util.List;

/**
 * Created by Hannu Lohtander on 4.4.2016.
 */
public interface FileMetaRepository {

    public FileMetaData createMetaDate(String oldName, String newName, long size);

    public List<FileMetaData> getList();

}
