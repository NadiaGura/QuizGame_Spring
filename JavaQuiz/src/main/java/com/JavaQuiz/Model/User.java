package com.JavaQuiz.Model;

import javax.persistence.*;

//Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
@Entity
@Table
public class User {

    //id will be a PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    private String password;
    private String email;


    //DEFAULT CONSTRUCTOR
    public User(){
    }

    public User(int id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password=password;
        this.email=email;
    }

    //GETTERS/SETTERS

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
