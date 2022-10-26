package com.example.weatherAlertDemo.repository;

import com.example.weatherAlertDemo.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Integer> {
}
