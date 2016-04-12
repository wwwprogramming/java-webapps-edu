package edu.uta.sis.spring.service.impl;


import edu.uta.sis.spring.service.FileUploadService;
import edu.uta.sis.spring.tietokanta.FileMetaRepository;
import edu.uta.sis.spring.tietokanta.FileRepository;
import edu.uta.sis.spring.tietokanta.UserRepository;
import edu.uta.sis.spring.tietokanta.entiteetit.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Hannu Lohtander on 3.4.2016.
 */
@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${files.upload.dir}")
    String filesUploadDir;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FileMetaRepository fileMetaRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = false)
    public String uploadFile(MultipartFile file, Long owner) {
        String newFileName = generateFilename(file.getOriginalFilename());
        User user = userRepository.getUser(owner.intValue());
        fileRepository.saveFile(filesUploadDir, newFileName, file);
        fileMetaRepository.createMetaDate(file.getOriginalFilename(), newFileName, file.getSize(), user);

        return newFileName;
    }

    private String generateFilename(String originalName) {
        // replace all non a-zA-z0-9_ with _
        // unique id... seconds since unix
        String newName = originalName.replaceAll("[^a-zA-Z0-9.-]", "_");
        return System.currentTimeMillis() / 1000 + "-" + newName;
    }
}
