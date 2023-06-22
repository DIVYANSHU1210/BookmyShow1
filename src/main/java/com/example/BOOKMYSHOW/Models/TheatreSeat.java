package com.example.BOOKMYSHOW.Models;

import com.example.BOOKMYSHOW.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "theatreSeat")
@Entity
public class TheatreSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;
}
