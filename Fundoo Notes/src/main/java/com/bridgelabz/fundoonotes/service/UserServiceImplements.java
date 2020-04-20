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
        return new Response("Login Successful", 200);
    }

    @Transactional
    @Override
    public Response register(RegisterDto registerDto) throws Exception, NullPointerException {

        //Fetching email from dto.
        Optional<User> userMail = userRepository.findUserByEmailId(registerDto.getEmailId());
        if (userMail.isEmpty()) {

            //Added Mapping to connect dto and entity and then saving in DB.
            User userInformation = modelMapper.map(registerDto, User.class);
            userRepository.save(userInformation);
            return new Response("Registration Successful", 200);
        }
        return new Response("Error", 400);
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
