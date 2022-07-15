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
    private Long id;
    @Column
    private String username;
    private String password;
    private String email;
    /*
    //CREATING DB RELATIONS
    @ManyToMany(cascade = CascadeType.ALL) //More info on cascade
    @JoinTable(name = "results",joinColumns =@JoinColumn(name=id(comment:user_id),inverseJoinColumns=@JoinColumn(name=id(comment:user_score))))
*/

    //DEFAULT CONSTRUCTOR
    public User(){
    }

    public User(String username, String password, String email) {
        this.username =username;
        this.password=password;
        this.email=email;
    }

    //GETTERS/SETTERS

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String name) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
