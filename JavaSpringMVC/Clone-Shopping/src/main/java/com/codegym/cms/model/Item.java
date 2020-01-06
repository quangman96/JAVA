package com.codegym.cms.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
    @ManyToMany
    @JoinTable(name = "item_product",
        joinColumns = @JoinColumn(name = "item_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Collection<Product> products;
    private int quantity;

    public Item() {}

    public Item(Collection<Product> products, int quantity) {
        this.products = products;
        this.quantity = quantity;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
