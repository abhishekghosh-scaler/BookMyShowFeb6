package com.scaler.bookyshow6feb.repositories;

import com.scaler.bookyshow6feb.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>
{
    @Override
    Booking save(Booking booking);
}
