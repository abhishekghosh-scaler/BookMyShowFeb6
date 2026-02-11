package com.scaler.bookyshow6feb.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingResponseDto
{
    private Long bookingId;
    private ResponseStatus status;
    private String failureMessage;
}
