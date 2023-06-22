package com.example.BOOKMYSHOW.DTOs.RequestDtos;


import lombok.Data;

@Data
public class TheatreSeatEntryDto {

    private int NoOfSeatsInARow;

    private int NoOfBasicSeats;

    private int NoOfReclinerSeats;

    private String location;
}
