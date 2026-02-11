package com.scaler.bookyshow6feb.repositories;

import com.scaler.bookyshow6feb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
}
