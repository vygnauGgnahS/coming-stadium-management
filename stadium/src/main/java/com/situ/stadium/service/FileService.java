package com.situ.stadium.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    /**
     * 上传头像
     * @param file 上传的头像
     * @param type 图片类型,用于文件夹分类
     * @return 返回访问路径
     */
    String uploadAvatar(MultipartFile file, String type);
}
