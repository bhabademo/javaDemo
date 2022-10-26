package com.example.weatherAlertDemo.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestWeatherServiceImpl {
	
	WeatherService weatherService = new WeatherServiceImpl();
	
	/**
	 * verify random temperature less then the upper bound is returned.
	 */
	@Test
	public void testGetCityTemprature() {
		String test_city = "Pune";
		int randomTemprature = weatherService.getCityTemperature(test_city);
		assertTrue(randomTemprature < 50, "Temprature is lessthan 50");
	}

}
