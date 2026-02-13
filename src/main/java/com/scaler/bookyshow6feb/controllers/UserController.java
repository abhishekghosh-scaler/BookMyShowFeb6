package com.scaler.bookyshow6feb.controllers;

import com.scaler.bookyshow6feb.dtos.ResponseStatus;
import com.scaler.bookyshow6feb.dtos.SignUpRequestDto;
import com.scaler.bookyshow6feb.dtos.SignUpResponseDto;
import com.scaler.bookyshow6feb.models.User;
import com.scaler.bookyshow6feb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController
{
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto)
    {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try
        {
            User user = userService.signUp(signUpRequestDto.getUsername(),
                    signUpRequestDto.getPassword());

            signUpResponseDto.setStatus(ResponseStatus.SUCCESS);
            signUpResponseDto.setUserId(user.getId());
        }catch (Exception ex)
        {
            signUpResponseDto.setStatus(ResponseStatus.FAILURE);
            signUpResponseDto.setFailureMessage(ex.getMessage());
        }
        return signUpResponseDto;
    }

    public void login(String username, String password)
    {
        userService.login(username, password);
    }
}
