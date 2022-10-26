package com.example.weatherAlertDemo.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author bhaba
 * 
 * This class is responsible to provide random temprature for a city
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    /**
     *	provide random temprature for a city
     */
    @Override
    public int getCityTemperature(String city){
        return getRandomTemperature();
    }
    private int getRandomTemperature(){
        Random random = new Random();
        int upperbound = 50;
        //generate random values from 0-50
        int randomTemprature = random.nextInt(upperbound);
        randomTemprature = 20;
        return randomTemprature;
    }
}
