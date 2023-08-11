package com.librarySystem.RestAPI.Repository;

import com.librarySystem.RestAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;


public interface UserRepository extends JpaRepository<User, Integer> {
    // void login();

    //@Modifying
//    @Query("UPDATE Library_User u set u.borrowedDate=:borrowedDate where u.userId=:userId")
//    User getBorrowedDate(Date borrowedDate, Integer userId);

    User findByName(String name);
}
