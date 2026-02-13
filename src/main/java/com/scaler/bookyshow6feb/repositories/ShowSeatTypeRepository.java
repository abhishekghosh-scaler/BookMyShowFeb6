package com.scaler.bookyshow6feb.repositories;

import com.scaler.bookyshow6feb.models.Show;
import com.scaler.bookyshow6feb.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long>
{
    List<ShowSeatType> findByShow(Show show);
}
