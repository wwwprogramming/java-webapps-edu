package edu.uta.sis.spring.web;


import edu.uta.sis.spring.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 4.4.2016.
 */
@Controller
public class FilesListController {

    @Autowired
    FileDownloadService fileDownloadService;

    @RequestMapping("/files/list")
    public String list(Model model) {
        model.addAttribute("fileList", fileDownloadService.getFileList());

        return "/files/list";
    }

}
