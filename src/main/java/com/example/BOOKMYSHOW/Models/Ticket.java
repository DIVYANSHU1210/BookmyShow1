package com.example.BOOKMYSHOW.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Table(name = "tickets")
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int total_price;

    private Date date;

    private LocalTime time;

    private String movieName;

    private String theatreName;

//    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
//    private List<ShowSeat> showSeats = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private User user;
}
