package com.yf.resources.controller;

import com.yf.resources.config.FastDFSClientWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @GetMapping("/upload")
    public String  uploadFile(MultipartFile multipartFile){
        try {
            String thumbImage = fastDFSClientWrapper.uploadImageAndCrtThumbImage(multipartFile);
            log.info("上传成功: {} ",thumbImage);
            return thumbImage;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

}
