package com.example.BOOKMYSHOW.Controllers;


import com.example.BOOKMYSHOW.DTOs.RequestDtos.AddTheatreDto;
import com.example.BOOKMYSHOW.DTOs.RequestDtos.TheatreSeatEntryDto;
import com.example.BOOKMYSHOW.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;


    @PostMapping("/addTheatre")
    public String addTheatre(@RequestBody AddTheatreDto addTheatreDto){
        return  theatreService.addTheatre(addTheatreDto);
    }



    @PostMapping("/addTheatreSeats")
    public String addTheatreSeats(@RequestBody TheatreSeatEntryDto seatEntryDto){
        try{
            return theatreService.addTheatreSeats(seatEntryDto);
        }
        catch(Exception e){
            return e.getMessage();
        }

    }
}
