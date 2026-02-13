package com.scaler.bookyshow6feb;

import com.scaler.bookyshow6feb.controllers.UserController;
import com.scaler.bookyshow6feb.dtos.ResponseStatus;
import com.scaler.bookyshow6feb.dtos.SignUpRequestDto;
import com.scaler.bookyshow6feb.dtos.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookyShow6FebApplication implements CommandLineRunner
{
    @Autowired
    UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookyShow6FebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
//        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
//        signUpRequestDto.setUsername("test3@scaler");
//        signUpRequestDto.setPassword("password");
//
//        SignUpResponseDto signUpResponseDto = userController.signUp(signUpRequestDto);
//        if(signUpResponseDto.getStatus().equals(ResponseStatus.SUCCESS))
//        {
//            System.out.println("User registration successful");
//        }else
//        {
//            System.out.println("User registration failed");
//        }

        userController.login("test3@scaler", "password123");
    }
}
