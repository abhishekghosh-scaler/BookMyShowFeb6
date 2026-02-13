package com.scaler.bookyshow6feb.repositories;

import com.scaler.bookyshow6feb.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>
{
    List<ShowSeat> findAllById(Long id);

    /*
    * If Id is present => update
    * If Id is null => insert
    * */
    @Override
    ShowSeat save(ShowSeat showseat);
}
