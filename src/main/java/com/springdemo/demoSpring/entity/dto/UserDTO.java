package com.springdemo.demoSpring.entity.dto;


import com.springdemo.demoSpring.entity.classes.User;

public class UserDTO {

    private String username;

    public String getUsername() {
        return username;
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
    }
}
