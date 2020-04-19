package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.LoginDto;
import com.bridgelabz.fundoonotes.dto.RegisterDto;
import com.bridgelabz.fundoonotes.model.MailObject;
import com.bridgelabz.fundoonotes.model.Response;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class UserServiceImplements implements UserService {

    private User userInformation = new User();
    
    @Autowired
    private UserRepository userRepository;

    //Fetching the mail object class from model.
    @Autowired
    private MailObject mailObject;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public Response login(LoginDto loginDto) {

        Optional<User> user = userRepository.findUserByEmailId(loginDto.getEmailId());
        return new Response(200, "Login Successful");
    }

    @Transactional
    @Override
    public Response register(RegisterDto registerDto) {
        Optional<User> userMail = userRepository.findUserByEmailId(registerDto.getEmailId());
        if (userMail != null) {
            userInformation = modelMapper.map(registerDto, User.class);
            return new Response(200, "Registration Successful");
        }
        return new Response(400, "Error");
    }

    @Transactional
    @Override
    public Boolean isUserExist(String email) {

        //Fetching from email id.
        Optional<User> user = userRepository.findUserByEmailId(email);
        if (user != null) {

            //Setting values in mail object.
            mailObject.setEmail(email);
            mailObject.setSubject("verification");
            return true;
        } else {
            return false;
        }
    }
}
