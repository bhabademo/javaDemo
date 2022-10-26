package com.example.weatherAlertDemo.dao;

import com.example.weatherAlertDemo.model.Location;
import com.example.weatherAlertDemo.model.Preference;
import com.example.weatherAlertDemo.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface WeatherDao {

    List<Preference> getAllPreferences();

    Preference updatePreference(Preference preference);

    int saveUser(User user);

    int savePreference(Preference preference);

    Preference findPreferenceById(int preferenceId);
}
