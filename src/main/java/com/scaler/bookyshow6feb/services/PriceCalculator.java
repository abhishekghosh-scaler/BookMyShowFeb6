package com.scaler.bookyshow6feb.services;

import com.scaler.bookyshow6feb.models.Show;
import com.scaler.bookyshow6feb.models.ShowSeat;

import java.util.List;

public interface PriceCalculator
{
    double calculatePrice(List<ShowSeat> showSeats, Show show);
}
