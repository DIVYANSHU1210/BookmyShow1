package com.example.BOOKMYSHOW.Repositories;

import com.example.BOOKMYSHOW.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where age > :givenAge", nativeQuery = true)
    List<User> findByAgeGreaterThen(int givenAge);
    //This is a custom function that you have defined
    //You need to write a query on top of this
}
