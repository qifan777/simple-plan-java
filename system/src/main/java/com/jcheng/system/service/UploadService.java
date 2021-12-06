package com.jcheng.system.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    String upload(MultipartFile multipartFile) throws IOException;

    String uploadByPath(MultipartFile multipartFile, String path) throws IOException;

    int delete(String url);
}
