package edu.uta.sis.mvc1.domain.service.impl;

import edu.uta.sis.mvc1.domain.repository.FileRepository;
import edu.uta.sis.mvc1.domain.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${files.upload.dir}")
    String filesUploadDir;

    @Autowired
    FileRepository fileRepository;

    public String uploadFile(MultipartFile file) {
        String newFileName = generateFilename(file.getOriginalFilename());
        fileRepository.saveFile(filesUploadDir, newFileName, file);


        return newFileName;
    }

    private String generateFilename(String originalName) {
        // replace all non a-zA-z0-9_ with _
        // unique id... seconds since unix
        String newName = originalName.replaceAll("[^a-zA-Z0-9.-]", "_");
        return System.currentTimeMillis() / 1000 + "-" + newName;
    }
}
