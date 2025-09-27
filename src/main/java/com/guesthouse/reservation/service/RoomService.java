package com.guesthouse.reservation.service;

import com.guesthouse.reservation.model.Room;
import com.guesthouse.reservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getRoomsByGuestHouse(Long guestHouseId) {
        return roomRepository.findByGuestHouseId(guestHouseId);
    }
    
    public List<Room> getAvailableRooms(Long guestHouseId, LocalDate checkInDate, LocalDate checkOutDate) {
        return roomRepository.findAvailableRooms(guestHouseId, checkInDate, checkOutDate);
    }
    
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }
    
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
}