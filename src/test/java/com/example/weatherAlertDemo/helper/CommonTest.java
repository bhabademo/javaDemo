package com.example.weatherAlertDemo.helper;

import com.example.weatherAlertDemo.dto.UserPreference;

public class CommonTest {
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

}
