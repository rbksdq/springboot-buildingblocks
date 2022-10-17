package com.stacksimplify.restservices.dtos;

import com.stacksimplify.restservices.entities.Order;

import java.util.List;

public class UserMmDto {

    private  Long id;
    private String username;
    private String firstname;
    private List<Order> order;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

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

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}
