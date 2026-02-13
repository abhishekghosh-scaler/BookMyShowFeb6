package com.scaler.bookyshow6feb.services;

import com.scaler.bookyshow6feb.models.Show;
import com.scaler.bookyshow6feb.models.ShowSeat;
import com.scaler.bookyshow6feb.models.ShowSeatType;
import com.scaler.bookyshow6feb.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceCalculatorImpl implements PriceCalculator{
    private final ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorImpl(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    @Override
    public double calculatePrice(List<ShowSeat> showSeats, Show show)
    {
        double totalPrice = 0;
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findByShow(show);
        for (ShowSeat showSeat : showSeats)
        {
            for (ShowSeatType showSeatType : showSeatTypes)
            {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType()))
                {
                    totalPrice += showSeatType.getPrice();
                    break;
                }
            }
        }

        return totalPrice;
    }
}
