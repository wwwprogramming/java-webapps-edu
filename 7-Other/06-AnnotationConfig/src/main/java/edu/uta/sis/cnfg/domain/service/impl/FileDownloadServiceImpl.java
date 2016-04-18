package edu.uta.sis.cnfg.domain.service.impl;

import edu.uta.sis.cnfg.domain.entities.FileMetaData;
import edu.uta.sis.cnfg.domain.repository.FileMetaRepository;
import edu.uta.sis.cnfg.domain.repository.FileRepository;
import edu.uta.sis.cnfg.domain.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
@Service("fileDownloadService")
public class FileDownloadServiceImpl implements FileDownloadService {

    @Value("${files.upload.dir}")
    String filesUploadDir;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FileMetaRepository fileMetaRepository;

    public HashMap<String,String> getFileList() {

        String[] files = fileRepository.getFileList(filesUploadDir);
        HashMap<String,String> fileData = new HashMap<String, String>();
        if (files != null) {
            for (String s : files) {
                fileData.put(s, s);
            }
        }
        return fileData;
    }

    public List<FileMetaData> getFileMetadata() {
        return fileMetaRepository.getList();
    }

    public Resource getFile(String id) {
        // @TODO
        return null;
    }

}
