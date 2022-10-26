package com.example.weatherAlertDemo.configuration;

import com.example.weatherAlertDemo.service.NotificationService;
import com.example.weatherAlertDemo.service.PreferenceManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalTime;

/**
 * @author bhaba
 * 
 * This class is responsible for creating a scheduler configuration to get user preferences and 
 * send notifications continuously for the matching preferences. 
 *
 */
@Configuration
@EnableScheduling
public class NotificationScheduler {

    @Autowired
    PreferenceManagementService preferenceManagementService;
    
    @Autowired
    NotificationService notificationService;

    /**
     * Check the database for new preferences every 2 minutes and send notification for matching preferences.
     */
    @Scheduled(cron="*/120 * * * * *")
    public void checkForNotification(){
        System.out.println(LocalTime.now() + "  -----------running the sceduled job...........................");
        preferenceManagementService.updateAllMatchingPreferences();
        notificationService.sendNotification();
    }
}
