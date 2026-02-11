package com.scaler.bookyshow6feb.controllers;

import com.scaler.bookyshow6feb.dtos.BookingRequestDto;
import com.scaler.bookyshow6feb.dtos.BookingResponseDto;
import com.scaler.bookyshow6feb.dtos.ResponseStatus;
import com.scaler.bookyshow6feb.models.Booking;
import com.scaler.bookyshow6feb.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController
{
    private final BookingService bookingService;
    public BookingController(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }

    public BookingResponseDto bookMovie(BookingRequestDto bookingRequestDto)
    {
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        try
        {
            Booking booking = bookingService.booking(bookingRequestDto.getShowSeatIds(),
                    bookingRequestDto.getUserId(), bookingRequestDto.getShowId());

            bookingResponseDto.setBookingId(booking.getId());
            bookingResponseDto.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception ex)
        {
            bookingResponseDto.setFailureMessage(ex.getMessage());
            bookingResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return bookingResponseDto;
    }
}
