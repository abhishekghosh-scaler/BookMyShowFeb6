package com.scaler.bookyshow6feb.services;

import com.scaler.bookyshow6feb.models.Booking;

import java.util.List;

public interface BookingService
{
    Booking booking(List<Long> showSeatIds, Long userId, Long showId);
}
