package com.example.weatherAlertDemo.notification;

import com.example.weatherAlertDemo.model.Preference;

public class EmailNotification implements Notification {
    @Override
    public void sendNotification(Preference preference) {
        System.out.println("Sending notification to email.......................");
    }
}
