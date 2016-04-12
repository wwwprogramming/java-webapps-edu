package edu.uta.sis.mvc1.domain.repository.impl;

import edu.uta.sis.mvc1.domain.repository.FileRepository;
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

    public void saveFile(String location, String name, MultipartFile file) {
        try{
            //create a temp file
            File temp = new File(location + name);
            file.transferTo(temp);


        }catch(IOException e){

            e.printStackTrace();

        }
    }

    public String[] getFileList(String location) {
        return new File(location).list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".pdf");
            }
        });
    }
}
