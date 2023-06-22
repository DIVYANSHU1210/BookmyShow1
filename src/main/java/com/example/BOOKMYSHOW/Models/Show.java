package com.example.BOOKMYSHOW.Models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Data
@Table(name = "shows")
@Entity
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalTime time;

    @ManyToOne
    @JoinColumn
    private Theatre theatre;

    @ManyToOne
    @JoinColumn
    private Movie movie;

//    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
//    private List<ShowSeat> showSeatList = new ArrayList<>();

}
