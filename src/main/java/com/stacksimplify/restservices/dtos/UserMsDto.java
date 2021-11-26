package com.stacksimplify.restservices.dtos;

public class UserMsDto {

    private Long id;
    private String username;
    private String email;
    private String rolename;

    public UserMsDto() {
    }

    public UserMsDto(Long id, String username, String email, String rolename) {
       super();
        this.id = id;
        this.username = username;
        this.email = email;
        this.rolename= rolename;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRolename() { return rolename; }

    public void setRolename(String rolename) { this.rolename = rolename;}
}
