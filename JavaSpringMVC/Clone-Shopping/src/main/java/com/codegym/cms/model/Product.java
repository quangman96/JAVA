package com.codegym.cms.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "products")
public class Product {

    @Id
//    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private Long amount;

    private Long price;

    private boolean isDelete;

    private String image;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

//    @OneToMany(mappedBy = "product")
//    private Set<Item> items;

    @ManyToMany(mappedBy = "products")
    private Collection<Item> items;
    public Product(){}

    public Product(int id,String name, Long amount, Long price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
    public Product(int id,String name, Long amount, Long price, String image) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }
}
