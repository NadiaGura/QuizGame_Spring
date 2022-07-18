package com.JavaQuiz.Model;

import javax.persistence.*;

//Entity annotation specifies that current class is an Entity and is mapped to a particular table in a DB
@Entity
@Table(name = "user")
public class User {

    //id will be a PK
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //what is difference between GenerationType.IDENTITY?
    @Column(name = "id")
    private int id;
    @Column
    private String name;
    private String password;
    @Column(unique = true)
    private String email;
    /*
    //CREATING DB RELATIONS
    @ManyToMany(cascade = CascadeType.ALL) //More info on cascade
    @JoinTable(name = "results",joinColumns =@JoinColumn(name=id(comment:user_id),inverseJoinColumns=@JoinColumn(name=id(comment:user_score))))
*/

    //DEFAULT CONSTRUCTOR
    public User(){
    }

    public User(String name, String password, String email) {
        this.name =name;
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
        this.name = this.name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
