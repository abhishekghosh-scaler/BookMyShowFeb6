package com.scaler.bookyshow6feb.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel
{
    @OneToOne
    private Screen screen;

    @OneToOne
    private Movie movie;
    private Date time;
}
