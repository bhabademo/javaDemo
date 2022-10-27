package com.example.weatherAlertDemo.service;

import com.example.weatherAlertDemo.controller.UserPreferenceController;
import com.example.weatherAlertDemo.dao.WeatherDao;
import com.example.weatherAlertDemo.dto.UserPreference;
import com.example.weatherAlertDemo.exception.SaveResourceException;
import com.example.weatherAlertDemo.model.Preference;
import com.example.weatherAlertDemo.model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author bhaba
 * 
 * Class responsible for saving user preference details
 *
 */
@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {

    @Autowired
    private WeatherDao weatherDao;
    
    private static final Logger LOGGER = LogManager.getLogger(UserPreferenceServiceImpl.class);

    UserPreferenceServiceImpl(){

    }

    /**
     *	Calls dao methods to save user preference details
     */
    @Override
    @Transactional
    public int saveUserPreferenceData(UserPreference userPreference){
        User user = getUserData(userPreference);
        Preference preference = getUserPreference(userPreference);
        int userId = weatherDao.saveUser(user);
        if(userId == 0) {
        	LOGGER.error("Error while saving user. Please check the database connection details.");
        	throw new SaveResourceException("Error while saving user.");
        }
        preference.setUserId(userId);
        int preferenceId = weatherDao.savePreference(preference);
        if(preferenceId == 0) {
        	LOGGER.error("Error while saving preference. Please check the database connection details.");
        	throw new SaveResourceException("Error while saving preference.");
        }
        LOGGER.info("User preference successfully saved with preferenceId - "+preferenceId);
        return preferenceId;
    }

    /**
     * @param userPreference
     * @return Preference
     * 
     * Retrieves only preference details from UserPreference instance
     */
    private Preference getUserPreference(UserPreference userPreference) {
        Preference preference = new Preference();
        preference.setCity(userPreference.getCityPreference());
        preference.setTemprature(userPreference.getTempraturePreference());
        preference.setCriteria(userPreference.getCriteria());
        preference.setNotificationType(userPreference.getNotificationType());
        
        return preference;
    }

    /**
     * @param userPreference
     * @return User
     * Retrieves only user details from UserPreference instance
     */
    private User getUserData(UserPreference userPreference) {
        User user = new User();
        user.setName(userPreference.getUserName());
        user.setEmailId(userPreference.getEmailId());
        user.setMobileNo(userPreference.getMobileNo());
        user.setUserCity((userPreference.getUserCity()));

        return user;
    }
}
