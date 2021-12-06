package com.jcheng.system.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.*;
import com.jcheng.system.config.oss.OSSInfo;
import com.jcheng.system.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OSSUploadServiceImpl implements UploadService {
    @Autowired
    OSS oss;
    @Autowired
    OSSInfo ossInfo;

    @Override
    public String upload(MultipartFile multipartFile) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String objectName = sdf.format(new Date()) + filename;
        return basicUpload("plan-manager/" + objectName, multipartFile.getInputStream());
    }

    @Override
    public String uploadByPath(MultipartFile multipartFile, String path) throws IOException {
        String filename = multipartFile.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String objectName = path + "/" + sdf.format(new Date()) + filename;
        return basicUpload(objectName, multipartFile.getInputStream());
    }

    @Override
    public int delete(String url) {
        url = url.replace("/resource/", "");
        String[] splits = url.split("/");
        StringBuilder filename1 = new StringBuilder();
        for (int i = 0; i <= splits.length - 1; i++) {
            filename1.append("/").append(splits[i]);
        }
        String filename2 = filename1.substring(1, filename1.length());
        oss.deleteObject(ossInfo.getBucketName(), filename2);
        return 1;
    }

    public String basicUpload(String objectName, InputStream inputStream) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossInfo.getBucketName(), objectName, inputStream);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        metadata.setObjectAcl(CannedAccessControlList.PublicRead);
        putObjectRequest.setMetadata(metadata);
        oss.putObject(putObjectRequest);

        String url = "https://" + ossInfo.getBucketName() + "." +
                ossInfo.getEndpoint().replace("https://", "") +
                "/" + objectName;
        return url;
    }
}
