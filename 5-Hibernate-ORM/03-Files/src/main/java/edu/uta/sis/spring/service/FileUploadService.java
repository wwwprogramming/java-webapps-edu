package edu.uta.sis.spring.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
public interface FileUploadService {

    /**
     *
     * @param file
     * @return filename of the uploaded file
     */
    public String uploadFile(MultipartFile file, Long owner);
}
