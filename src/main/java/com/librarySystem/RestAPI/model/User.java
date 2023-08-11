package com.librarySystem.RestAPI.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "Library_User")
@Getter
@Setter
public class User {

    public User() {

    }
    public User(Integer userId, String bookName, String name, String email, Date borrowedDate, Date returnedDate) {
        this.userId = userId;
        this.bookName = bookName;
        this.name = name;
        this.email = email;
        this.borrowedDate = borrowedDate;
        this.returnedDate = returnedDate;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;


    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date borrowedDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnedDate;

    @Column(name = "bookName")
    private String bookName;


}
