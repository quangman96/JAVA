package com.codegym.model;

import javax.persistence.*;

@Entity
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String aboutme;
   public User(){}
   public User ( String name,String aboutme){
       this.name =name;
       this.aboutme =aboutme;
   }
    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s']", id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public void setName(String name) {
        this.name = name;
    }

}
