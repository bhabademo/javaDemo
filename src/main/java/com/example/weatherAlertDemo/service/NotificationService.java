package com.example.weatherAlertDemo.service;

import com.example.weatherAlertDemo.model.Preference;

import java.util.Map;

public interface NotificationService {
    public void updatePreferenceList(Preference preference);

    //public Map<Integer, String> getAppNotificationMap();

   //public void setAppNotificationMap(Map<Integer, String> appNotificationMap);

    public void sendNotification();

    public void clearPreferenceList();

    public Preference getNotificationForUser(int preferenceId);
}
