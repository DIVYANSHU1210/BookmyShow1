package com.example.BOOKMYSHOW.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Theatres")
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(unique = true)
    private String location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<TheatreSeat>theatreSeats = new ArrayList<>();


    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();


}
