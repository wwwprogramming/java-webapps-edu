package edu.uta.sis.mvc1.web;

import edu.uta.sis.mvc1.domain.entities.FileMetaData;
import edu.uta.sis.mvc1.domain.service.FileDownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Hannu Lohtander on 4.4.2016.
 */
@Controller
public class FilesMetaController {

    @Autowired
    FileDownloadService fileDownloadService;

    @RequestMapping("/files/metadata")
    public String metadatalist(Model model) {
        model.addAttribute("metaData", fileDownloadService.getFileMetadata());
        return "/files/metadata";
    }
}
