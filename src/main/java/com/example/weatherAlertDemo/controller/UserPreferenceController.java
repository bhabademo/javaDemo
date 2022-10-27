package com.example.weatherAlertDemo.controller;

import com.example.weatherAlertDemo.dto.UserPreference;
import com.example.weatherAlertDemo.service.UserPreferenceService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author bhaba
 * 
 * Controller end point to save user preferences.
 *
 */
@CrossOrigin("*")
@RestController
@RequestMapping
public class UserPreferenceController {
	
	private static final Logger LOGGER = LogManager.getLogger(UserPreferenceController.class);

    @Autowired
    UserPreferenceService userPreferenceService;

    @PostMapping(value = "/savePreference", produces= {"application/json"},  consumes= {"application/json"})
    public ResponseEntity<Integer> saveUserPrefence(@RequestBody @Validated UserPreference userPreference){
    	LOGGER.info("saveUserPrefence Request recievied with - "+userPreference);
    	int preferenceId = userPreferenceService.saveUserPreferenceData(userPreference);

        return new ResponseEntity<Integer>(preferenceId, HttpStatus.OK);
    }

}
