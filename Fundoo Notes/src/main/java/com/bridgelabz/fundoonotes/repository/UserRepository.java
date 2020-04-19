package com.bridgelabz.fundoonotes.repository;

import com.bridgelabz.fundoonotes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Interface extending the Jpa repository to access database values.
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where id=?", nativeQuery = true)
    String login();

    //Inserting the values in DataBase.
    @Query(value = "insert into user (id,firstName,lastName, emailId, mobileNumber, password) values (?, ?, ?, ?, ?, ?)", nativeQuery = true)
    User register(User user);

    @Query(value = "select * from user where emailId=?", nativeQuery = true)
    Optional<User> findUserByEmailId(String email);
}
