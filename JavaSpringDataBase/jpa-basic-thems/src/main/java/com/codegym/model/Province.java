package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String name;
    private long numOfCitizen;

    public List getCustomers() {
        return customers;
    }

    public void setCustomers(List customers) {
        this.customers = customers;
    }

    @OneToMany( targetEntity=Customer.class,mappedBy = "province" )
    private List customers;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumOfCitizen() {
        return numOfCitizen;
    }

    public void setNumOfCitizen(long numOfCitizen) {
        this.numOfCitizen = numOfCitizen;
    }
}
