package com.example.weatherAlertDemo.notification;

import com.example.weatherAlertDemo.model.Preference;

public interface Notification {
    void sendNotification(Preference preference);
}
