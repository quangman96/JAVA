package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class FormImages {
    private Long id;
    private String nameImages;
    private String description;
    private MultipartFile file;
    private int quantity;
    private String images;
    public FormImages(){}

    public FormImages(Long id, String nameImages, String description, String images) {
        this.id = id;
        this.nameImages = nameImages;
        this.description = description;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameImages() {
        return nameImages;
    }

    public void setNameImages(String nameImages) {
        this.nameImages = nameImages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void incQuantity() {
        this.quantity++;
    }


    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
