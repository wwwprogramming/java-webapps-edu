package edu.uta.sis.mvc1.domain.repository;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
public interface FileRepository {

    void saveFile(String location, String name, MultipartFile file);

    String[] getFileList(String location);
}
