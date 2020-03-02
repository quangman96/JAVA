package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "datatype")
public class DataType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDataType;
    private String nameDataType;
    private int isDeleted =0;

    @OneToMany(mappedBy = "datatype")
    @JsonIgnore
    private Set<DataProduct> dataProducts;

    public Long getIdDataType() {
        return idDataType;
    }

    public void setIdDataType(Long idDataType) {
        this.idDataType = idDataType;
    }

    public String getNameDataType() {
        return nameDataType;
    }

    public void setNameDataType(String nameDataType) {
        this.nameDataType = nameDataType;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Set<DataProduct> getDataProducts() {
        return dataProducts;
    }

    public void setDataProducts(Set<DataProduct> dataProducts) {
        this.dataProducts = dataProducts;
    }
}
