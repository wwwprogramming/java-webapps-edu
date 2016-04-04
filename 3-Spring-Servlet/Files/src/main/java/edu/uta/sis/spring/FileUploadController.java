package edu.uta.sis.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Hannu Lohtander on 2.4.2016.
 */

@Controller
public class FileUploadController {

    @RequestMapping(value = "/upload/file", method = RequestMethod.POST)
    public String file(@RequestParam("file") MultipartFile file, Model model) {
        String fileName = null;
        String targetPath = tmpPath();
        if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                // Where to upload at the server when running webapp
                // ....../tomcat/webapp/ROOT/...?
                // or
                // ....../tomcat/webapp/resources/uploads
                // or
                // .... where.... C:\temp /tmp temp ...

                BufferedOutputStream buffStream =
                        new BufferedOutputStream(new FileOutputStream(new File(targetPath + File.separator + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                model.addAttribute("message", "You have successfully uploaded " + fileName);
            } catch (Exception e) {
                model.addAttribute("message","You failed to upload " + fileName + ": " + e.getMessage());
            }
        } else {
            model.addAttribute("message", "empty file");
        }
        return "/home";
    }

    private String tmpPath() {
        try{
            //create a temp file
            File temp = File.createTempFile("temp-file-name", ".tmp");

            //Get tempropary file path
            String absolutePath = temp.getAbsolutePath();
            String tempFilePath = absolutePath.
                    substring(0,absolutePath.lastIndexOf(File.separator));
            temp.delete();
            return tempFilePath;

        }catch(IOException e){

            e.printStackTrace();

        }
        return "C:\tmp";
    }

}
