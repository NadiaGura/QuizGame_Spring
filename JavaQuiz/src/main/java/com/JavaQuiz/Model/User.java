package com.JavaQuiz.Model;

import javax.persistence.*;

@Entity
@Table
public class User {

    //id will be a PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;


    //DEFAULT CONSTRUCTOR
    public User(){
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //GETTERS/SETTERS

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
