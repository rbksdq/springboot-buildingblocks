package com.stacksimplify.restservices.entities;

//import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

//entity
@Entity //(name = "user")
@Table(name = "User")
//@JsonFilter(value = "userFilter") --for mappingJackson filtering
//@JsonIgnoreProperties({"firstname","lastname"}) . part of static filtering
public class User {

    @Id
    @GeneratedValue
    @JsonView(Views.External.class)
    private Long id;

    @NotEmpty(message= "username is Mandatory field. please enter username")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    @JsonView(Views.External.class)
    private String username;

    @Size(min=2, message = "firstName should be at least 2 characters")
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String firstname;

    @Column(name = "Last_NAME", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String lastname;

    @Column(name = "Email_Address", length = 50, nullable = false)
    @JsonView(Views.External.class)
    private String email;

    @Column(name = "Role", length = 50, nullable = false)
    @JsonView(Views.Internal.class)
    private  String role;

    @Column(name = "SSN", length = 50, nullable = false, unique = true)
    //@JsonIgnore static filtering part
    @JsonView(Views.Internal.class)
    private String ssn;


    @OneToMany (mappedBy = "user") //reference side foreign key
    @JsonView(Views.Internal.class)
    private List<Order> order;

    @Column(name = "ADDRESS")
    private String address;


    //no argument constructor
    public User() {
        //super();
        }

    // fields constructor

    public User(Long id, String username, String firstname, String lastname, String email, String role, String ssn, List<Order> order, String address) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
        this.order = order;
        this.address = address;
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


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    //ToString
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
                ", order=" + order +
                ", address='" + address + '\'' +
                '}';
    }
}
