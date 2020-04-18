package com.bridgelabz.fundoonotes.serviceimplimentation;

import com.bridgelabz.fundoonotes.dto.LoginDto;
import com.bridgelabz.fundoonotes.dto.RegisterDto;
import com.bridgelabz.fundoonotes.model.Response;
import com.bridgelabz.fundoonotes.model.User;
import com.bridgelabz.fundoonotes.repository.UserRepository;
import com.bridgelabz.fundoonotes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class UserServiceImplements implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public Response login(LoginDto loginDto) {

        Optional<User> user = userRepository.findUserByEmailId(loginDto.getEmailId());
        return new Response(HttpStatus.OK, "Login Successful");
    }

    @Transactional
    @Override
    public Response register(RegisterDto registerDto) {
        Optional<User> userMail = userRepository.findUserByEmailId(registerDto.getEmailId());
        if (userMail != null)
            return new Response(HttpStatus.OK, "Registration Successful");
        return new Response(HttpStatus.BAD_REQUEST, "Error");

    }
}
