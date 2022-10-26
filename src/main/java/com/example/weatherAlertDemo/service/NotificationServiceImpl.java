package com.example.weatherAlertDemo.service;

import com.example.weatherAlertDemo.dao.WeatherDao;
import com.example.weatherAlertDemo.exception.ResourceNotFoundException;
import com.example.weatherAlertDemo.model.Preference;
import com.example.weatherAlertDemo.notification.Notification;
import com.example.weatherAlertDemo.notification.NotificationFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bhaba
 *
 * Service class to handle notification related operations.
 */
@Service
public class NotificationServiceImpl implements NotificationService{

    List<Preference> updatedPreferenceList = new ArrayList<Preference>();
    
    @Autowired
    private WeatherDao weatherDao;
    
    /**
     *	Param Preference
     *	updates Preference List
     */
    @Override
    public void updatePreferenceList(Preference preference) {
        updatedPreferenceList.add(preference);
    }

    /**
     *	gets notification object from NotificationFactory based on the notification type and sends notification
     */
    @Override
	public void sendNotification(){
        NotificationFactory notificationFactory = new NotificationFactory();
        updatedPreferenceList.forEach((preference) -> {
            Notification notification = notificationFactory.createNotification(preference.getNotificationType());
            notification.sendNotification(preference);
        });
    }

    /**
     *	removes items from updatedPreferenceList
     */
    @Override
    public void clearPreferenceList() {
        updatedPreferenceList.clear();
    }

    /**
     *  @Param preferenceId
     *	get Notification for user with given preferenceId
     */
    @Override
    public Preference getNotificationForUser(int preferenceId) throws ResourceNotFoundException{
        return weatherDao.findPreferenceById(preferenceId);
    }
}
