package com.example.BOOKMYSHOW.Transformers;

import com.example.BOOKMYSHOW.DTOs.RequestDtos.AddTheatreDto;
import com.example.BOOKMYSHOW.Models.Theatre;

public class TheatreTransformer {

    public static Theatre convertDtoToTheatre(AddTheatreDto addTheatreDto){
        Theatre theatre = Theatre.builder().name(addTheatreDto.getName()).location(addTheatreDto.getLocation()).build();
        return theatre;
    }
}
