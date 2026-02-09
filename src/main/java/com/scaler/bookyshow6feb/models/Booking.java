package com.scaler.bookyshow6feb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel
{
    private Date bookedAt;

    @ManyToOne
    private User bookedBy;
    private double totalAmount;

    @OneToMany
    private List<Payment> payments;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @ManyToMany
    private List<ShowSeat> seats;
}

/*
* Booking : ShowSeat
* 1 : M
* */
