package com.example.weatherAlertDemo.notification;

import com.example.weatherAlertDemo.model.Preference;
import org.springframework.stereotype.Service;

@Service
public class AppNotification implements Notification {

    @Override
    public void sendNotification(Preference preference) {
        System.out.println("Sending notification to application.......................");
        String message = String.format("%s city temprature is %s than %s now", preference.getCity(), preference.getCriteria(), preference.getTemprature() );
        System.out.println("notification ----: "+ message);
    }
}
