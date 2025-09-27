package com.guesthouse.reservation.controller;

import com.guesthouse.reservation.model.City;
import com.guesthouse.reservation.model.GuestHouse;
import com.guesthouse.reservation.service.CityService;
import com.guesthouse.reservation.service.GuestHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    
    @Autowired
    private CityService cityService;
    
    @Autowired
    private GuestHouseService guestHouseService;
    
    @GetMapping
    public String home(Model model) {
        List<City> cities = cityService.getAllCities();
        model.addAttribute("cities", cities);
        return "index";
    }
    
    @GetMapping("/city/{cityName}")
    public String cityGuestHouses(@PathVariable String cityName, Model model) {
        List<GuestHouse> guestHouses = guestHouseService.getGuestHousesByCity(cityName);
        model.addAttribute("cityName", cityName);
        model.addAttribute("guestHouses", guestHouses);
        return "city-guesthouses";
    }
    
    @GetMapping("/guesthouse/{id}")
    public String guestHouseDetails(@PathVariable Long id, Model model) {
        GuestHouse guestHouse = guestHouseService.getGuestHouseById(id);
        if (guestHouse == null) {
            return "redirect:/";
        }
        model.addAttribute("guestHouse", guestHouse);
        return "guesthouse-details";
    }
}