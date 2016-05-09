package edu.uta.sis.calendars.web.files;

import edu.uta.sis.calendars.domain.service.FileDownloadService;
import edu.uta.sis.calendars.domain.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by Hannu Lohtander on 4.4.2016.
 */
@Controller
public class FileUploadController {

 @Autowired
    FileUploadService fileUploadService;

    @Autowired
    FileDownloadService fileDownloadService;

    @RequestMapping(value="/files/upload", method = RequestMethod.GET)
    public String upload() {
        return "/files/upload/form";
    }




    @RequestMapping(value="/files/upload", method = RequestMethod.POST)
    public String doUpload(@RequestParam("file") MultipartFile multipartFile, Model model) throws IOException{
        try {
            String newFileName = fileUploadService.uploadFile(multipartFile);
        } catch (IOException ioe) {

        }
            return "redirect:/files/list";
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView manageException() {

        return new ModelAndView();
    }


}
