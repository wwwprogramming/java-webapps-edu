package edu.uta.sis.calendars.data.repository.impl;

import edu.uta.sis.calendars.data.repository.FileRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
@Repository
public class FileRepositoryImpl implements FileRepository {


    public void saveFile(String location, String name, MultipartFile file) throws IOException{

            //create a temp file
            File temp = new File(location + name);
            file.transferTo(temp);



    }

    public String[] getFileList(String location) {
        return new File(location).list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".pdf");
            }
        });
    }
}
