package com.example.weatherAlertDemo.service;

import com.example.weatherAlertDemo.dao.WeatherDao;
import com.example.weatherAlertDemo.dao.WeatherDaoImpl;
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

import javax.annotation.Resource;


/**
 * @author bhaba
 * 
 * test methods in UserPreferenceServiceImpl
 *
 */
class UserPreferenceServiceImplTest {

	@Mock
	WeatherDao weatherDao;
	
    UserPreference userPreference;
    
    @InjectMocks
    @Resource
    UserPreferenceService userPreferenceService = new UserPreferenceServiceImpl();

    @BeforeEach
    void setUp() {
        userPreference = createUserPreference();
        MockitoAnnotations.openMocks(this);        
    }

    private UserPreference createUserPreference() {
        UserPreference userPreference = new UserPreference();
        userPreference.setUserName(TestConstants.TEST_USERNAME);
        userPreference.setUserCity(TestConstants.TEST_CITY);
        userPreference.setMobileNo(TestConstants.TEST_MOBILRNO);
        userPreference.setEmailId(TestConstants.TEST_EMAILID);
        userPreference.setCityPreference(TestConstants.TEST_CITY_PREFERENCE);
        userPreference.setTempraturePreference(TestConstants.TEST_TEMP_PREFERENCE);
        userPreference.setCriteria(TestConstants.TEST_CRITERIA);

        return userPreference;
    }

    /**
     * verify actions in UserPreferenceServiceImpl.saveUserPreferenceData()
     */
    @Test
    void testSaveUserPreferenceData() {
    	Mockito.when(weatherDao.saveUser((User) any())).thenReturn(TestConstants.TEST_USERID);
        Mockito.when(weatherDao.savePreference((Preference) any())).thenReturn(TestConstants.TEST_PREFERNCEID);
        int preferenceId = userPreferenceService.saveUserPreferenceData(userPreference);
        assertEquals(TestConstants.TEST_PREFERNCEID, preferenceId, "preference id" );
    }
}