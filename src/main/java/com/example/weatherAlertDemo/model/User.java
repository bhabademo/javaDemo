package com.example.weatherAlertDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="userId",nullable=false)
    private int userId;

    @Column(name = "userName")
    private String name;

    @Column(name = "mobileNo")
    private String mobileNo;

    @Column(name = "emailId")
    private String emailId;

    @Column(name = "userCity")
    private String userCity;
}
