package com.yf.resources.controller;

import com.yf.resources.config.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    public void  uploadFile(MultipartFile multipartFile){
        try {
            String thumbImage = fastDFSClientWrapper.uploadImageAndCrtThumbImage(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
