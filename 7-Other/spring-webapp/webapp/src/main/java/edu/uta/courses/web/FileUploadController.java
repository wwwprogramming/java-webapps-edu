package edu.uta.courses.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by me on 21.3.2015.
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    Logger logger = Logger.getLogger(FileUploadController.class.getName());

    private @Value("${uploadPath:#{null}}") String uploadPath = null;


    @RequestMapping(value="/upload")
    public String singleUpload(){
        return "/file/upload";
    }

    @RequestMapping(value="/save", method= RequestMethod.POST )
    public @ResponseBody
    String singleSave(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc ){

        String fileName = null;
        String targetPath = uploadPath == null ? tmpPath(): uploadPath;
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
                return "You have successfully uploaded " + fileName;
            } catch (Exception e) {
                return "You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
            return "Unable to upload. File is empty.";
        }
    }

    private String tmpPath() {
        try{
            //create a temp file
            File temp = File.createTempFile("temp-file-name", ".tmp");

            //Get tempropary file path
            String absolutePath = temp.getAbsolutePath();
            String tempFilePath = absolutePath.
                    substring(0,absolutePath.lastIndexOf(File.separator));

            return tempFilePath;

        }catch(IOException e){

            e.printStackTrace();

        }
        return "temp";
    }

}
