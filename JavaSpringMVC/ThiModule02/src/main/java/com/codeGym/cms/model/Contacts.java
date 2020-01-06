package com.codeGym.cms.model;

import org.jboss.logging.Message;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "contacts")

public class Contacts {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = ("First name khong duoc de trong"))
    private String firstName;
    @NotEmpty(message = ("Last Name khong duoc de trong"))
    private String lastName;
    @NotEmpty(message = ("SDT khong duoc de trong"))
    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b" ,message = ("So dien thoai ko dung, thu voi so 0912345678"))
    private String phoneNumber;
    @NotEmpty(message = ("Email khong duoc de trong"))
    private String email;
    @NotEmpty(message = ("Address khong duoc de trong"))
    private String address;

    public Contacts( String firstName,String lastName,String phoneNumber,String email,String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Contacts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
