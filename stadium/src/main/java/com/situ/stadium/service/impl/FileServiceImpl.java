package com.situ.stadium.service.impl;

import com.situ.stadium.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Value("${upload.file.location}")
    private String uploadFileLocation;
    @Value("${upload.server.prefix}")
    private String serverPrefix;


    @Override
    public String uploadAvatar(MultipartFile file, String type) {
        String fileName = file.getOriginalFilename();
        int dotIndex = -1;
        String ext = null;
        if (fileName != null && !fileName.isEmpty()) {
            dotIndex = fileName.lastIndexOf(".");
            if (dotIndex != -1) {
                ext = fileName.substring(dotIndex);
            }
        }
        if (ext == null) {
            return "";
        }
        if (!(ext.equalsIgnoreCase(".jpg") || ext.equalsIgnoreCase(".jpeg") || ext.equalsIgnoreCase(".png"))) {
            return "";
        }

        fileName = UUID.randomUUID() + ext;
        String url = serverPrefix + type + "/" + fileName;
        File filePath = new File(uploadFileLocation + type + "/" + fileName);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return url;
    }
}
