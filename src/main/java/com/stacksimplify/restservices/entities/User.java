package com.stacksimplify.restservices.entities;

//import javax.persistence.*;

import javax.persistence.*;

//entity
@Entity //(name = "user")
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String username;
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