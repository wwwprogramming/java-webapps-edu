package edu.uta.sis.spring.tietokanta;

import edu.uta.sis.spring.tietokanta.entiteetit.FileMetaData;
import edu.uta.sis.spring.tietokanta.entiteetit.User;

import java.util.List;

/**
 * Created by Hannu Lohtander on 4.4.2016.
 */
public interface FileMetaRepository {

    public FileMetaData createMetaDate(String oldName, String newName, long size, User owner);

    public List<FileMetaData> getList();

}
