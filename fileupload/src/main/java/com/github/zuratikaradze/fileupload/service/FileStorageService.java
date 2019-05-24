package com.github.zuratikaradze.fileupload.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {

    private String fileStorageLocation = "E:/TUTORIALS/SpringTutorials/uploadDownloadFiles/storage";

    public String storeFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        try {
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = Paths.get(fileStorageLocation + "/" + fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return fileName;
    }

    public Resource loadFileAsResource(String fileName) {
        Path filePath = Paths.get(fileStorageLocation + "/" + fileName);
        Resource resource = null;
        try {
            resource = new UrlResource(filePath.toUri());
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }
        return resource;
    }
}
