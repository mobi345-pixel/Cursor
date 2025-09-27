package com.guesthouse.reservation.config;

import com.guesthouse.reservation.model.*;
import com.guesthouse.reservation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;
    
    @Autowired
    private GuestHouseRepository guestHouseRepository;
    
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeData();
    }

    private void initializeData() {
        // Create cities
        City rawalpindi = new City("Rawalpindi");
        City murree = new City("Murree");
        City nathiaGali = new City("Nathia Gali");
        City lahore = new City("Lahore");
        
        cityRepository.saveAll(Arrays.asList(rawalpindi, murree, nathiaGali, lahore));

        // Create guest houses for Rawalpindi
        GuestHouse rawalpindiGH1 = new GuestHouse(
            "Rawalpindi Guest House",
            "123 Mall Road, Rawalpindi",
            "A comfortable guest house in the heart of Rawalpindi with modern amenities and easy access to local attractions.",
            rawalpindi
        );
        rawalpindiGH1.setAmenities("WiFi, Air Conditioning, Parking, Restaurant");
        
        GuestHouse rawalpindiGH2 = new GuestHouse(
            "City Center Lodge",
            "456 Saddar Road, Rawalpindi",
            "Conveniently located guest house near shopping areas and transportation hubs.",
            rawalpindi
        );
        rawalpindiGH2.setAmenities("WiFi, Air Conditioning, Laundry Service");

        // Create guest houses for Murree
        GuestHouse murreeGH1 = new GuestHouse(
            "Hill Station Retreat",
            "789 Mall Road, Murree",
            "Experience the beauty of Murree hills in our cozy guest house with panoramic mountain views.",
            murree
        );
        murreeGH1.setAmenities("WiFi, Heating, Mountain View, Restaurant, Parking");
        
        GuestHouse murreeGH2 = new GuestHouse(
            "Pine View Guest House",
            "321 Kashmir Point Road, Murree",
            "Peaceful guest house surrounded by pine trees, perfect for a relaxing mountain getaway.",
            murree
        );
        murreeGH2.setAmenities("WiFi, Heating, Garden, Parking");

        // Create guest houses for Nathia Gali
        GuestHouse nathiaGaliGH1 = new GuestHouse(
            "Nathia Gali Heights",
            "654 Nathia Gali Road, Nathia Gali",
            "Elevated guest house offering stunning views of the surrounding hills and valleys.",
            nathiaGali
        );
        nathiaGaliGH1.setAmenities("WiFi, Heating, Mountain View, Restaurant, Hiking Trails");
        
        GuestHouse nathiaGaliGH2 = new GuestHouse(
            "Valley View Lodge",
            "987 Nathia Gali Main Road, Nathia Gali",
            "Charming guest house with traditional architecture and modern comforts.",
            nathiaGali
        );
        nathiaGaliGH2.setAmenities("WiFi, Heating, Traditional Architecture, Garden");

        // Create guest houses for Lahore
        GuestHouse lahoreGH1 = new GuestHouse(
            "Lahore Heritage Guest House",
            "147 The Mall, Lahore",
            "Historic guest house in the cultural heart of Lahore, close to major landmarks and attractions.",
            lahore
        );
        lahoreGH1.setAmenities("WiFi, Air Conditioning, Cultural Tours, Restaurant, Parking");
        
        GuestHouse lahoreGH2 = new GuestHouse(
            "Modern City Lodge",
            "258 Gulberg Main Boulevard, Lahore",
            "Contemporary guest house in Lahore's modern district with all modern amenities.",
            lahore
        );
        lahoreGH2.setAmenities("WiFi, Air Conditioning, Gym, Restaurant, Business Center");

        guestHouseRepository.saveAll(Arrays.asList(
            rawalpindiGH1, rawalpindiGH2,
            murreeGH1, murreeGH2,
            nathiaGaliGH1, nathiaGaliGH2,
            lahoreGH1, lahoreGH2
        ));

        // Create rooms for each guest house
        createRoomsForGuestHouse(rawalpindiGH1, Arrays.asList(
            new Room("R101", "Standard Room", 2, new BigDecimal("50.00"), "Comfortable standard room with basic amenities", rawalpindiGH1),
            new Room("R102", "Deluxe Room", 3, new BigDecimal("75.00"), "Spacious deluxe room with modern facilities", rawalpindiGH1),
            new Room("R103", "Family Room", 4, new BigDecimal("100.00"), "Large family room perfect for groups", rawalpindiGH1)
        ));

        createRoomsForGuestHouse(rawalpindiGH2, Arrays.asList(
            new Room("C201", "Standard Room", 2, new BigDecimal("45.00"), "Clean and comfortable standard room", rawalpindiGH2),
            new Room("C202", "Deluxe Room", 3, new BigDecimal("70.00"), "Well-appointed deluxe room", rawalpindiGH2)
        ));

        createRoomsForGuestHouse(murreeGH1, Arrays.asList(
            new Room("M301", "Mountain View Room", 2, new BigDecimal("80.00"), "Room with stunning mountain views", murreeGH1),
            new Room("M302", "Deluxe Mountain Room", 3, new BigDecimal("120.00"), "Premium room with panoramic mountain views", murreeGH1),
            new Room("M303", "Family Mountain Room", 4, new BigDecimal("150.00"), "Large family room with mountain views", murreeGH1)
        ));

        createRoomsForGuestHouse(murreeGH2, Arrays.asList(
            new Room("P401", "Pine View Room", 2, new BigDecimal("70.00"), "Room overlooking pine forests", murreeGH2),
            new Room("P402", "Deluxe Pine Room", 3, new BigDecimal("100.00"), "Spacious room with pine forest views", murreeGH2)
        ));

        createRoomsForGuestHouse(nathiaGaliGH1, Arrays.asList(
            new Room("N501", "Valley View Room", 2, new BigDecimal("90.00"), "Room with beautiful valley views", nathiaGaliGH1),
            new Room("N502", "Deluxe Valley Room", 3, new BigDecimal("130.00"), "Premium room with stunning valley views", nathiaGaliGH1),
            new Room("N503", "Family Valley Room", 4, new BigDecimal("160.00"), "Large family room with valley views", nathiaGaliGH1)
        ));

        createRoomsForGuestHouse(nathiaGaliGH2, Arrays.asList(
            new Room("V601", "Traditional Room", 2, new BigDecimal("75.00"), "Room with traditional architecture", nathiaGaliGH2),
            new Room("V602", "Deluxe Traditional Room", 3, new BigDecimal("110.00"), "Spacious traditional room", nathiaGaliGH2)
        ));

        createRoomsForGuestHouse(lahoreGH1, Arrays.asList(
            new Room("L701", "Heritage Room", 2, new BigDecimal("60.00"), "Room with traditional Lahore architecture", lahoreGH1),
            new Room("L702", "Deluxe Heritage Room", 3, new BigDecimal("90.00"), "Spacious heritage room", lahoreGH1),
            new Room("L703", "Family Heritage Room", 4, new BigDecimal("120.00"), "Large family room with heritage charm", lahoreGH1)
        ));

        createRoomsForGuestHouse(lahoreGH2, Arrays.asList(
            new Room("G801", "Modern Room", 2, new BigDecimal("55.00"), "Contemporary room with modern amenities", lahoreGH2),
            new Room("G802", "Deluxe Modern Room", 3, new BigDecimal("85.00"), "Spacious modern room", lahoreGH2),
            new Room("G803", "Executive Room", 2, new BigDecimal("110.00"), "Executive room with business facilities", lahoreGH2)
        ));
    }

    private void createRoomsForGuestHouse(GuestHouse guestHouse, java.util.List<Room> rooms) {
        rooms.forEach(room -> {
            room.setGuestHouse(guestHouse);
            roomRepository.save(room);
        });
    }
}