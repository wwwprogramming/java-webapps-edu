package edu.uta.sis.spring;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Hannu Lohtander on 2.4.2016.
 */

@Controller
@RequestMapping("/download/*")
public class FileDownloadController {


    @RequestMapping(value = "file/{id}", method = RequestMethod.GET)
    public void getFile(
            @PathVariable("id") String id, HttpServletResponse response) {
        try {
            response.setContentType("text/plain");
            response.setHeader("X-FILENAME", "test-wildcard");
            // get your file as InputStream
            Resource file = new ClassPathResource("test"+id+".txt");
            // copy it to response's OutputStream
            FileCopyUtils.copy(file.getInputStream(), response.getOutputStream());

            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }

    }
}
