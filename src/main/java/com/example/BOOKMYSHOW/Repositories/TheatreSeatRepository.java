package com.example.BOOKMYSHOW.Repositories;


import com.example.BOOKMYSHOW.Models.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeat, Integer> {
}
