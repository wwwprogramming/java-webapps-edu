package edu.uta.sis.app1.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

/**
 * Created by Hannu Lohtander on 9.4.2016.
 */

@Controller
public class JsonExamplesController {

    @RequestMapping("/json1")
    public String json1(Model model) throws IOException {
        Resource json1File = new ClassPathResource("files/json1.json");
        if (json1File.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json1File.getInputStream());
            Integer age = root.path("age").intValue();
            String name = root.path("name").textValue();
            model.addAttribute("name", name);
            model.addAttribute("age", age);
        }
        return "/json/json1";
    }

    @RequestMapping("/json2")
    public String json2(Model model) throws IOException{
        Resource json1File = new ClassPathResource("files/json1.json");
        if (json1File.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            AgeNamePojo pojo = mapper.readValue(json1File.getFile(), AgeNamePojo.class);
            model.addAttribute("pojo", pojo);

        }
        return "/json/json2";
    }

    @RequestMapping("/json3")
    public String json3(Model model)  throws IOException{
        Resource json2File = new ClassPathResource("files/json2.json");
        if (json2File.exists()) {
            ObjectMapper mapper = new ObjectMapper();
            AgeNamePojo2 pojo = mapper.readValue(json2File.getFile(), AgeNamePojo2.class);
            model.addAttribute("pojo", pojo);

        }
        return "/json/json3";
    }

    @RequestMapping(value = "/json4", method = RequestMethod.GET)
    public String json4a() {

        return "/json/json4";
    }

    @RequestMapping(value = "/json4", method = RequestMethod.POST)
    public String json4(Model model, @ModelAttribute("form") AgeNamePojo pojo)  throws IOException{
        Resource jsonResources = new ClassPathResource("files/");

        File file = new File(jsonResources.getFile().getAbsolutePath() + File.separatorChar + "json4.json");
        file.createNewFile();
        if (file.exists()) {
            StringWriter writer = new StringWriter();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new FileOutputStream(file), pojo);
            mapper.writeValue(writer, pojo);
            model.addAttribute("data",writer.toString());

        }
        return "/json/json4";
    }



    @ExceptionHandler(value = IOException.class)
    public String iOExceptionHandler(Model model, IOException exception) {
        model.addAttribute("message", exception.getMessage());
        return "/json/ioexception";
    }

}
