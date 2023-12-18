package com.example.demo.infrastructure.web.controller.FOTO.controllers;

import com.example.demo.infrastructure.web.controller.FOTO.controllers.services.UploadFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/upload")
public class UploadFilesController {

    //@Autowired
    //UploadFilesService uploadFilesService;

    //@PostMapping("/picture")
    //private ResponseEntity<String> uploadPic(@RequestParam("file") MultipartFile file) throws Exception {
      //  String response = uploadFilesService.handleFileUpload(file);
        //return ResponseEntity.ok(response);
    //}
}
