package com.example.BOOKMYSHOW.DTOs.RequestDtos;


import lombok.Data;

@Data
public class AddUserDTO {

    private String name;
    private int age;
    private String email;
    private String mobileNum;
}
