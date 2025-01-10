package com.springdemo.demoSpring.controllers;

import com.springdemo.demoSpring.classes.Role;
import com.springdemo.demoSpring.entity.classes.User;
import com.springdemo.demoSpring.entity.dto.UserDTO;
import com.springdemo.demoSpring.entity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

@Controller // This means that this class is a Controller
@RestController
@RequestMapping(path="/users") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserRepository userRepository;




    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestBody User user) {

        User userInsert = new User();
        userInsert.setPassword(user.getPassword());
        userInsert.setUsername(user.getUsername());
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserDTO> getAllUsers() {
        // This returns a JSON or XML with the users
        Iterable<User> list = userRepository.findAll();
        LinkedList<UserDTO> dtos = new LinkedList<>();
        list.forEach((user -> dtos.add(new UserDTO(user))));
        return dtos;
    }
}