package com.scaler.bookyshow6feb.services;

import com.scaler.bookyshow6feb.models.User;

public interface UserService
{
    User signUp(String username, String password);
    void login(String username, String password);
}
