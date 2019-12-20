package com.codegym.model;

import javax.persistence.*;

@Entity
@Table (name = "images")
public class Images {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private  String images;
    private String nameImages;
    private String description;
    public Images(){
    }
    public Images(String images,String nameImages, String description){
        this.images =images;
        this.nameImages=nameImages;
        this.description = description;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
