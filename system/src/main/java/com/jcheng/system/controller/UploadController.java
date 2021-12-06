package com.jcheng.system.controller;


import com.jcheng.common.domain.R;
import com.jcheng.common.exception.CustomException;
import com.jcheng.system.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {
    @Autowired
    UploadService uploadService;

    @PostMapping("/upload")
    public R<Map<String, String>> uploadImg(@RequestParam Map<String, MultipartFile> files, String path) {
        List<String> arrayList = new ArrayList<>();
        files.forEach((String key, MultipartFile file) -> {
            try {
                log.info(key);
                String url = uploadService.upload(file);
                arrayList.add(url);
            } catch (Exception e) {
                throw new CustomException("上传失败");
            }
        });
        String join = String.join(";", arrayList);
        Map<String, String> urlMap = new HashMap<>();
        urlMap.put("url", join);
        return R.ok(urlMap);
    }


    @GetMapping("/deleteObject")
    public R<Boolean> deleteObject(@RequestParam("url") String url) {
        uploadService.delete(url);
        return R.ok(true);
    }
}
