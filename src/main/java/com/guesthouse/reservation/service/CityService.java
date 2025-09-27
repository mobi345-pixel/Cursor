package com.guesthouse.reservation.service;

import com.guesthouse.reservation.model.City;
import com.guesthouse.reservation.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    
    @Autowired
    private CityRepository cityRepository;
    
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }
    
    public City getCityByName(String name) {
        return cityRepository.findByName(name);
    }
    
    public City saveCity(City city) {
        return cityRepository.save(city);
    }
}