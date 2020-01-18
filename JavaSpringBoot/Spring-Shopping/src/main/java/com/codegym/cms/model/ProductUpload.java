package com.codegym.cms.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductUpload extends Product {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
