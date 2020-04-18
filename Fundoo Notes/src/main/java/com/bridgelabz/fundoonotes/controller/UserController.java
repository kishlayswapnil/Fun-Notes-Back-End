package com.bridgelabz.fundoonotes.controller;

import com.bridgelabz.fundoonotes.dto.LoginDto;
import com.bridgelabz.fundoonotes.dto.RegisterDto;
import com.bridgelabz.fundoonotes.model.Response;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.serviceimplimentation.UserServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//For creating a REST api.
@RestController
public class UserController {

    //Injecting the object dependency.
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImplements userService;

    //Login API with mapping.
    @PostMapping("/login")
    public ResponseEntity<Response> login(@Valid @RequestBody LoginDto loginDto) {
        Response response = userService.login(loginDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //Registration API with mapping.
    @PostMapping("/registration")
    public ResponseEntity<Response> register(@Valid @RequestBody RegisterDto registerDto) {
        Response response = userService.register(registerDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    //API for reset the forget password.
    @PostMapping("/forgetPassword")
    public ResponseEntity<Response> forgetPassword(@RequestParam("email") String email) {
        boolean result = userService.isUserExist(email);
        if (result)
            return new ResponseEntity(result, HttpStatus.OK);
        return new ResponseEntity(result, HttpStatus.BAD_REQUEST);

    }

}
