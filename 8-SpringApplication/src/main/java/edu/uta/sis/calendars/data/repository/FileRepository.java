package edu.uta.sis.calendars.data.repository;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
public interface FileRepository {

    void saveFile(String location, String name, MultipartFile file) throws IOException;

    String[] getFileList(String location);
}
