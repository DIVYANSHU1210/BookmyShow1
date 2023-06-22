package com.example.BOOKMYSHOW.Services;


import com.example.BOOKMYSHOW.DTOs.RequestDtos.AddUserDTO;
import com.example.BOOKMYSHOW.DTOs.ResponseDtos.UserResponseDTO;
import com.example.BOOKMYSHOW.Exceptions.NoUserFoundException;
import com.example.BOOKMYSHOW.Models.User;
import com.example.BOOKMYSHOW.Repositories.UserRepository;
import com.example.BOOKMYSHOW.Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public String addUser(AddUserDTO userDTO) {
        User user = UserTransformer.convertDtoToEntity(userDTO);
        userRepository.save(user);

        return "User Added Successfully";
    }


    public UserResponseDTO getOldestUser() throws NoUserFoundException {
        List<User> users = userRepository.findAll();

        int maxAge = Integer.MIN_VALUE;
        User oldestUser = null;

        for(User user : users){
            if(user.getAge() > maxAge){
                maxAge = user.getAge();;
                oldestUser = user;
            }
        }

        if(oldestUser == null){
            throw new NoUserFoundException("No User Exist");
        }
        UserResponseDTO userResponseDTO = UserTransformer.convertEntityToDto(oldestUser);
        return  userResponseDTO;
    }

    public List<User> getUserOlderThen(int age) {
        return userRepository.findByAgeGreaterThen(age);
    }
}
