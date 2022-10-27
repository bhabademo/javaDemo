package com.example.weatherAlertDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="preference")
public class Preference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="preferenceId",nullable=false)
    private int preferenceId;

    @Column(name="city")
    private String city;

    @Column(name="temprature")
    private int temprature;

    @Column(name="criteria")
    private String criteria;

    @Column(columnDefinition = "boolean default false")
    private boolean criteriaMatched;

    @Column(name="userId")
    private int userId;

    @Column(name = "notificationType")
    private String notificationType = "APP";
}
