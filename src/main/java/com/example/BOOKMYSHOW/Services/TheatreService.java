package com.example.BOOKMYSHOW.Services;


import com.example.BOOKMYSHOW.DTOs.RequestDtos.AddTheatreDto;
import com.example.BOOKMYSHOW.DTOs.RequestDtos.TheatreSeatEntryDto;
import com.example.BOOKMYSHOW.Enums.SeatType;
import com.example.BOOKMYSHOW.Models.Theatre;
import com.example.BOOKMYSHOW.Models.TheatreSeat;
import com.example.BOOKMYSHOW.Repositories.TheatreRepository;
import com.example.BOOKMYSHOW.Repositories.TheatreSeatRepository;
import com.example.BOOKMYSHOW.Transformers.TheatreTransformer;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

//    @Autowired
//    TheatreSeatRepository theatreSeatRepository;


    public String addTheatre(AddTheatreDto addTheatreDto) {

        //Entity that saves into the db
        //Convert the entryDto --> Entity and then save it

        Theatre theatre = TheatreTransformer.convertDtoToTheatre(addTheatreDto);

        theatreRepository.save(theatre);
        return "theatre added successfully";
    }



    public String addTheatreSeats(TheatreSeatEntryDto seatEntryDto) throws Exception {
        int noOfSeatsInARow = seatEntryDto.getNoOfSeatsInARow();

        int noOfBasicSeats = seatEntryDto.getNoOfBasicSeats();

        int noOfReclinerSeats = seatEntryDto.getNoOfReclinerSeats();

        String location = seatEntryDto.getLocation();

        Theatre theatre = theatreRepository.findByLocation(location);

        if(theatre == null)throw new Exception("Theatre not found");

        List<TheatreSeat> theatreSeatList = theatre.getTheatreSeats() ;

        int counter = 1;
        char ch = 'A';
        //add basic seats int the theater
        for(int i=1; i<=noOfBasicSeats; i++){
            String seatNo = counter + "";
            seatNo = seatNo + ch;

            ch++;

            if(ch - 'A' == noOfSeatsInARow){
                ch = 'A';
                counter++;
            }
            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(seatNo);
            theatreSeat.setTheatre(theatre);
            theatreSeat.setSeatType(SeatType.BASIC);
//            theatreSeatRepository.save(theatreSeat);
            theatreSeatList.add(theatreSeat);
        }


        //add recliner seats int the theater
        for(int j=1; j<=noOfReclinerSeats; j++){
            String seatNo = counter + "";
            seatNo = seatNo + ch;

            ch++;

            if(ch - 'A' == noOfSeatsInARow){
                ch = 'A';
                counter++;
            }
            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(seatNo);
            theatreSeat.setTheatre(theatre);
            theatreSeat.setSeatType(SeatType.RECLINER);
//            theatreSeatRepository.save(theatreSeat);
            theatreSeatList.add(theatreSeat);
        }

//        theatre.setTheatreSeats(theatreSeatList);


        theatreRepository.save(theatre);

        return "Theater seats added successfully";
    }


}
