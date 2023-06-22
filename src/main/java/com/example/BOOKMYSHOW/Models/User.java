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
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String emailId;

    private int age;

    private String mobileNo;

//    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL)
//    private List<Ticket> ticketList = new ArrayList<>();


}
