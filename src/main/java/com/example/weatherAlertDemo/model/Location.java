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
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="locationId",nullable=false)
    private int locationId;

    @Column(name="country")
    private String country;

    @Column(name="state")
    private String state;

    @Column(name="city")
    private String city;

    @Column(name="userId")
    private int userId;
}
