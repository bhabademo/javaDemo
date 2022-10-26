package com.example.weatherAlertDemo.dao;

import com.example.weatherAlertDemo.exception.ResourceNotFoundException;
import com.example.weatherAlertDemo.model.Preference;
import com.example.weatherAlertDemo.model.User;
import com.example.weatherAlertDemo.repository.PreferenceRepository;
import com.example.weatherAlertDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@EnableCaching
public class WeatherDaoImpl implements WeatherDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PreferenceRepository preferenceRepository;

    public int saveUser(User user){
        user = userRepository.save(user);
        int userId = user.getUserId();
        return userId;
    }
    public int savePreference(Preference preference) {
        preference = preferenceRepository.save(preference);
        int preferenceId = preference.getPreferenceId();
        return preferenceId;
    }

    @Override
    @CachePut(value = "userPreferenceCache",  key = "#preferenceId")
    public Preference findPreferenceById(int preferenceId) {
       System.out.println("Fetch preference for --- " + preferenceId);
       return preferenceRepository.findById(preferenceId).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
    }

    @Override
    public List<Preference> getAllPreferences() {
        return preferenceRepository.findAll();
    }

    @Override
    @CachePut(value = "userPreferenceCache",  key = "#preferenceId")
    public Preference updatePreference(Preference preference) {
        preference = preferenceRepository.save(preference);
        return preference;
    }
}
