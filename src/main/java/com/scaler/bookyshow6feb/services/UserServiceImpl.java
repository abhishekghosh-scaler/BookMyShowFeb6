package com.scaler.bookyshow6feb.services;

import com.scaler.bookyshow6feb.models.User;
import com.scaler.bookyshow6feb.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    /*
    * This is a terrible way to code.
    * We should create bean, and hook it.
    * */
    private final BCryptPasswordEncoder bCryptPasswordEncoder
            = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(String username, String password)
    {
        Optional<User> userOptional = userRepository.findByUserName(username);
        if(userOptional.isPresent())
        {
            throw new RuntimeException("User already exists");
        }

        User user = new User();
        user.setUserName(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    @Override
    public void login(String username, String password)
    {
        Optional<User> userOptional = userRepository.findByUserName(username);
        if(userOptional.isEmpty())
        {
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();
        if(bCryptPasswordEncoder.matches(password, user.getPassword()))
        {
            System.out.println("User logged in successfully");
            return;
        }

        throw new RuntimeException("Wrong password");
    }
}
