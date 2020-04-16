package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.LoginDto;
import com.bridgelabz.fundoonotes.dto.UserDto;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//For creating a REST api.
@RestController
public class UserController {

    //Injecting the object dependency.
    @Autowired
    UserRepository repos;

    //Login API with mapping.
    @RequestMapping("/login")
    public LoginDto login(LoginDto loginDto) {
        return loginDto;
    }

    //Registration API with mapping.
    @RequestMapping("/registration")
    public List<UserDto> getRegister() {
        List<UserDto> user = (List<UserDto>) repos.findAll();
        return user;
    }
}
