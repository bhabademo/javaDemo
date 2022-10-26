package com.example.weatherAlertDemo.service;

import com.example.weatherAlertDemo.dao.WeatherDao;
import com.example.weatherAlertDemo.dto.UserPreference;
import com.example.weatherAlertDemo.helper.TestConstants;
import com.example.weatherAlertDemo.model.Preference;
import com.example.weatherAlertDemo.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

/**
 * @author Bhabavuti Pradhan
 *
 *	Tests PreferenceManagementServiceImpl
 */
class PreferenceManagementServiceImplTest {

    private static final int DEFAULT_TEMPRATURE = 20;

	@Mock
	WeatherDao weatherDao;
    
    @Mock
    NotificationService notificationService;
    
    @Mock
    WeatherService weatherService;
	
    
    @InjectMocks
    @Resource
    PreferenceManagementService preferenceManagementService = new PreferenceManagementServiceImpl();
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);        
    }
    
    /**
     * verify results from PreferenceManagementServiceImpl.updateAllMatchingPreferences()
     */
    @Test
    void testUpdateAllMatchingPreferences() {
    	Preference preference1 = new Preference(200, "London", "10", "greater", true, 25, "APP");
        Preference preference2 = new Preference(200, "Washington", "10", "greater", false, 29, "APP");
        List<Preference> preferences = new ArrayList<Preference>();
        preferences.add(preference1);
        preferences.add(preference2);
    	
        Mockito.when(weatherDao.getAllPreferences()).thenReturn(preferences);
    	Mockito.when(weatherService.getCityTemperature(any())).thenReturn(DEFAULT_TEMPRATURE);
    	
    	preferenceManagementService.updateAllMatchingPreferences();
    	
    	Mockito.verify(notificationService, times(1)).clearPreferenceList();
    	Mockito.verify(weatherDao, times(1)).updatePreference((Preference) any());
    	Mockito.verify(notificationService, times(1)).updatePreferenceList((Preference) any());
    }
}