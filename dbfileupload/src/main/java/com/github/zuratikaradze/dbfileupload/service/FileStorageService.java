package com.github.zuratikaradze.dbfileupload.service;

import com.github.zuratikaradze.dbfileupload.model.DBFile;
import com.github.zuratikaradze.dbfileupload.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class FileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) {
        String fileName = file.getOriginalFilename();

        try {
            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());
            dbFileRepository.save(dbFile);
            return dbFile;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public DBFile loadFileAsResource(Long fileId) {
        return dbFileRepository.findById(fileId).get();
    }
}
