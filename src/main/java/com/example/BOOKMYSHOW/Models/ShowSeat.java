package com.example.BOOKMYSHOW.Models;


import com.example.BOOKMYSHOW.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "ShowSeats")
@Entity
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int seatNo;
    private boolean isAvailable;

    private SeatType seatType;

    private boolean isFoodAttached;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private Ticket ticket;
}
