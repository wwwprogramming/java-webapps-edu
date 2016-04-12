package edu.uta.sis.mvc1.domain.service.impl;

import edu.uta.sis.mvc1.domain.repository.FileRepository;
import edu.uta.sis.mvc1.domain.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
@Service("fileDownloadService")
public class FileDownloadServiceImpl implements FileDownloadService {

    @Value("${files.upload.dir}")
    String filesUploadDir;

    @Autowired
    FileRepository fileRepository;

    public HashMap<String,String> getFileList() {

        String[] files = fileRepository.getFileList(filesUploadDir);
        HashMap<String,String> fileData = new HashMap<String, String>();
        for (String s: files) {
            fileData.put(s,s);
        }
        return fileData;
    }

    public Resource getFile(String id) {

        return null;
    }

}
