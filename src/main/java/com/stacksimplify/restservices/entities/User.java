package com.stacksimplify.restservices.entities;

//import javax.persistence.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

//entity
@Entity //(name = "user")
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message= "username is Mandatory field. please enter username")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String username;
    @Size(min=2, message = "firstName should be at least 2 characters")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    private String firstname;
    @Column(name = "Last_NAME", length = 50, nullable = false)
    private String lastname;
    @Column(name = "Email_Address", length = 50, nullable = false)
    private String email;
    @Column(name = "Role", length = 50, nullable = false)
    private  String role;
    @Column(name = "SSN", length = 50, nullable = false, unique = true)
    private String ssn;

    @OneToMany (mappedBy = "user") //reference side foreign key
    private List<Order> order;

    //no argument constructor
    public User() {
        //super();
        }

    // fields constructor

    public User(Long id, String username, String firstname, String lastname, String email, String role, String ssn) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
//tostring is optional .. required for bean logging

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
