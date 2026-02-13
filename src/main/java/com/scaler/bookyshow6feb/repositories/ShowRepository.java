package com.scaler.bookyshow6feb.repositories;

import com.scaler.bookyshow6feb.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long>
{
    @Override
    Optional<Show> findById(Long showId);
}
