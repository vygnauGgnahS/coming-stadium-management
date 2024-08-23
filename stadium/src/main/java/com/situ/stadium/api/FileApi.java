package com.situ.stadium.api;

import com.situ.stadium.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/files", produces = "application/json;charset=utf-8")
public class FileApi {
    private FileService uploadFileService;

    @Autowired
    public void setUploadFileService(FileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @PostMapping("/upload/avatar/{type}")
    public Map<String, Object> uploadAvatar(MultipartFile file, @PathVariable(value = "type") String type) {
        String url = this.uploadFileService.uploadAvatar(file, type);
        if (url == null) {
            return Map.of("success", false, "msg", "操作失败");
        } else if (url.isEmpty()) {
            return Map.of("success", false, "msg", "仅支持jpg/jpeg/png格式!");
        }
        return Map.of("success", true, "url", url);
    }

}
