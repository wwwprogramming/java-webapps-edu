package edu.uta.sis.spring.web;


import edu.uta.sis.spring.service.FileDownloadService;
import edu.uta.sis.spring.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String doUpload(@RequestParam("file") MultipartFile multipartFile, @AuthenticationPrincipal WwwUser user, Model model) {
        String newFileName = fileUploadService.uploadFile(multipartFile, user.getId());
        model.addAttribute("fileList", fileDownloadService.getFileList());

        model.addAttribute("newFileName", newFileName);
        return "/files/list";
    }


}
