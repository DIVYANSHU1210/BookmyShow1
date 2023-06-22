package com.example.BOOKMYSHOW.Transformers;

import com.example.BOOKMYSHOW.DTOs.RequestDtos.AddUserDTO;
import com.example.BOOKMYSHOW.DTOs.ResponseDtos.UserResponseDTO;
import com.example.BOOKMYSHOW.Models.User;

public class UserTransformer {

    public static User convertDtoToEntity(AddUserDTO addUserDTO){
        User userObj = User.builder().age(addUserDTO.getAge()).name(addUserDTO.getName()).emailId(addUserDTO.getEmail()).mobileNo(addUserDTO.getMobileNum()).build();
        return userObj;
    }


    public static UserResponseDTO convertEntityToDto(User user){
        UserResponseDTO userResponseDTO = UserResponseDTO.builder().name(user.getName()).age(user.getAge()).mobileNum(user.getMobileNo()).build();
        return userResponseDTO;
    }
}
