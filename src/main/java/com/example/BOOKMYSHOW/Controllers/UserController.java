package com.example.BOOKMYSHOW.Controllers;

import com.example.BOOKMYSHOW.DTOs.RequestDtos.AddUserDTO;
import com.example.BOOKMYSHOW.DTOs.ResponseDtos.UserResponseDTO;
import com.example.BOOKMYSHOW.Models.User;
import com.example.BOOKMYSHOW.Repositories.UserRepository;
import com.example.BOOKMYSHOW.Services.UserService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody  AddUserDTO user){
        try{
            String response =  userService.addUser(user);
            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getOldestUser")
    public UserResponseDTO getOldestUser(){
        try{
            UserResponseDTO userResponseDTO = userService.getOldestUser();
            userResponseDTO.setStatusCode("200");
            userResponseDTO.setStatusMessage("Success");
            return userResponseDTO;
        }
        catch (Exception e){
             UserResponseDTO userResponseDTO = new UserResponseDTO();
             userResponseDTO.setStatusCode("404");
             userResponseDTO.setStatusMessage("Not Found");
             return userResponseDTO;
        }
    }

    @GetMapping("/getUserOlderthen")
    public List<User> getUserOlderThen(@RequestParam("age") int age){
        return userService.getUserOlderThen(age);
    }
}
