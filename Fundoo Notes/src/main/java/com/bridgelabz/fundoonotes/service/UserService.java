package com.bridgelabz.fundoonotes.service;

import com.bridgelabz.fundoonotes.dto.LoginDto;
import com.bridgelabz.fundoonotes.dto.RegisterDto;
import com.bridgelabz.fundoonotes.model.Response;

public interface UserService {
    Response login(LoginDto user);

    Response register(RegisterDto userRecord);

    Boolean isUserExist(String email);
}
