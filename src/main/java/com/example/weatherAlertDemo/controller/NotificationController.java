package com.example.weatherAlertDemo.controller;

import com.example.weatherAlertDemo.model.Preference;
import com.example.weatherAlertDemo.service.NotificationService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author bhaba
 * 
 * Controller end point to get notification on the application
 *
 */
@CrossOrigin
@RestController
@RequestMapping
public class NotificationController {
    @Autowired
    NotificationService notificationService;
    
    private static final Logger LOGGER = LogManager.getLogger(NotificationController.class);

    @GetMapping(value = "/getNotification", produces= {"application/json"})
    public ResponseEntity<Preference> getNotification(@RequestParam int preferenceId){
    	LOGGER.info("Find notification for - "+preferenceId);
        Preference preference = notificationService.getNotificationForUser(preferenceId);
        return new ResponseEntity<Preference>(preference, HttpStatus.OK);
    }
}
