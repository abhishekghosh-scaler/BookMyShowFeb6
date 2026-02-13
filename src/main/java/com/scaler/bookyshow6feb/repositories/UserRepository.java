package com.scaler.bookyshow6feb.repositories;

import com.scaler.bookyshow6feb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    @Override
    Optional<User> findById(Long userId);
    Optional<User> findByUserName(String userName);

    @Override
    User save(User user);
}
