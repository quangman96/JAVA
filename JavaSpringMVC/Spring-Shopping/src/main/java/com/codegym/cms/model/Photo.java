package com.codegym.cms.model;

import org.springframework.web.multipart.MultipartFile;

public class Photo {
    private int id;
    private MultipartFile file;
    private int quantity;
    private String photo;
    private String name;
    private Long amount;
    private Long price;
    public Photo(){}
    public Photo(int id,String photo,String name, Long amount, Long price) {
        this.id = id;
        this.photo = photo;
        this.amount = amount;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
