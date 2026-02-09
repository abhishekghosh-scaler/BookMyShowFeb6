package com.scaler.bookyshow6feb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel
{
    private String name;

    @ManyToOne
    private SeatType seatType;
}

/*
* Seat SeatType
*  1      1
*  M      1
*
* Seat: SeatType = M:1
* */
