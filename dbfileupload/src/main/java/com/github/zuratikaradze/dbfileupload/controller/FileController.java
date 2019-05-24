package com.github.zuratikaradze.dbfileupload.controller;


import com.github.zuratikaradze.dbfileupload.Response.UploadFileResponse;
import com.github.zuratikaradze.dbfileupload.model.DBFile;
import com.github.zuratikaradze.dbfileupload.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {
    @Autowired
    private FileStorageService fileStorageService;


    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        DBFile dbFile = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/").path(dbFile.getId().toString()).toUriString();
        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {

        List<UploadFileResponse> uploadFileResponseList = new ArrayList<>();
        for (MultipartFile file : files) {
            uploadFileResponseList.add(uploadFile(file));
        }
        return uploadFileResponseList;
        //  return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long id, HttpServletRequest request) {

        DBFile dbFile = fileStorageService.loadFileAsResource(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
}
