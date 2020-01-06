package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "itemDetails")
public class ItemDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


}
