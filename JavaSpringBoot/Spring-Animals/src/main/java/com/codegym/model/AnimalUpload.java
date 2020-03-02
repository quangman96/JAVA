package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class AnimalsUpload extends Animals {
    private MultipartFile[] file;

    public MultipartFile[] getFile() {
        return file;
    }

    public void setFile(MultipartFile[] file) {
        this.file = file;
    }
}
