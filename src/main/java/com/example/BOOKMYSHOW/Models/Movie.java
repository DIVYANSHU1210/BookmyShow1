package com.example.BOOKMYSHOW.Models;

import com.example.BOOKMYSHOW.Enums.Genre;
import com.example.BOOKMYSHOW.Enums.Language;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Table(name = "movies")
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private int duration;

    @Column(scale = 2)
    private Double rating;


    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Date releaseDate;

    private Language language;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();

}
