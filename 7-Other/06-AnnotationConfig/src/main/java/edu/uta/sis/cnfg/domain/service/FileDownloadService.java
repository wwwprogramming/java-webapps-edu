package edu.uta.sis.cnfg.domain.service;

import edu.uta.sis.cnfg.domain.entities.FileMetaData;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
public interface FileDownloadService {

    public HashMap<String,String> getFileList();

    public List<FileMetaData> getFileMetadata();

}
