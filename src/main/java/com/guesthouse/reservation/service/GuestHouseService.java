package com.guesthouse.reservation.service;

import com.guesthouse.reservation.model.GuestHouse;
import com.guesthouse.reservation.repository.GuestHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestHouseService {
    
    @Autowired
    private GuestHouseRepository guestHouseRepository;
    
    public List<GuestHouse> getGuestHousesByCity(String cityName) {
        return guestHouseRepository.findGuestHousesByCityName(cityName);
    }
    
    public GuestHouse getGuestHouseById(Long id) {
        return guestHouseRepository.findById(id).orElse(null);
    }
    
    public GuestHouse saveGuestHouse(GuestHouse guestHouse) {
        return guestHouseRepository.save(guestHouse);
    }
}