package com.example.demo.infrastructure.web.controller.FOTO.controllers.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFilesService {

    String handleFileUpload (MultipartFile file, String rutaFoto) throws Exception;
}
