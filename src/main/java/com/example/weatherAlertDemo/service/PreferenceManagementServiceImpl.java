package com.example.weatherAlertDemo.service;

import com.example.weatherAlertDemo.controller.NotificationController;
import com.example.weatherAlertDemo.dao.WeatherDao;
import com.example.weatherAlertDemo.helper.Criteria;
import com.example.weatherAlertDemo.model.Preference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bhaba
 * 
 * This class is responsible for updating preferences based on matching ctiteria.
 *
 */
@Service
public class PreferenceManagementServiceImpl implements PreferenceManagementService {

    @Autowired
    private WeatherDao weatherDao;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private NotificationService notificationService;

    private static final Logger LOGGER = LogManager.getLogger(PreferenceManagementServiceImpl.class);

    /**
     * @param preference
     * @return Preference
     * 
     * Update the given preference if temperature criteria matches 
     */
    private Preference updatePreference(Preference preference){
        if(preference != null && matchPreferenceCriteria(preference)){
        	LOGGER.info("Found matching criteria for - "+preference.getPreferenceId());
            preference.setCriteriaMatched(true);
            weatherDao.updatePreference(preference);
            notificationService.updatePreferenceList(preference);
            return preference;
        }
        return preference;
    }

    /**
     * @param preference
     * @return preference
     * 
     * Checks if the temperature criteria matches for the given preference
     */
    private boolean matchPreferenceCriteria(Preference preference){
        int cityTemprature = weatherService.getCityTemperature(preference.getCity());
        LOGGER.info("Random city temperature retieved from weatherService - " + cityTemprature);
        String criteria = preference.getCriteria();
        int tempratureCriteria = preference.getTemprature();

        if(Criteria.GT.getValue().equals(criteria)){
            if(cityTemprature > tempratureCriteria){
                return true;
            }
        }
        if(Criteria.LT.getValue().equals(criteria)){
            if(cityTemprature < tempratureCriteria){
                return true;
            }
        }
        if(Criteria.EQ.getValue().equals(criteria)){
            if(cityTemprature == tempratureCriteria){
                return true;
            }
        }
        return false;
    }

    /**
     *	Retrieves all preference from database and updates those preferences for which the temperature criteria matches.
     */
    @Override
    public void updateAllMatchingPreferences(){
        notificationService.clearPreferenceList();
        List<Preference> preferenceList = weatherDao.getAllPreferences();
        if(!preferenceList.isEmpty()){
            preferenceList.stream().filter(preference -> !preference.isCriteriaMatched()).forEach(preference -> updatePreference(preference));
        }
    }
}
