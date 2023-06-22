package com.example.BOOKMYSHOW.DTOs.ResponseDtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String name;
    private int age;
    private String mobileNum;


    private String statusCode;

    private String statusMessage;
}
