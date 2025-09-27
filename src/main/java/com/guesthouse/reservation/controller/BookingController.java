package com.guesthouse.reservation.controller;

import com.guesthouse.reservation.model.Booking;
import com.guesthouse.reservation.model.Room;
import com.guesthouse.reservation.service.BookingService;
import com.guesthouse.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private BookingService bookingService;
    
    @GetMapping("/room/{roomId}")
    public String showBookingForm(@PathVariable Long roomId, 
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
                                 Model model) {
        Room room = roomService.getRoomById(roomId);
        if (room == null) {
            return "redirect:/";
        }
        
        model.addAttribute("room", room);
        model.addAttribute("checkIn", checkIn);
        model.addAttribute("checkOut", checkOut);
        model.addAttribute("booking", new Booking());
        
        return "booking-form";
    }
    
    @PostMapping("/create")
    public String createBooking(@ModelAttribute Booking booking, Model model) {
        try {
            Booking createdBooking = bookingService.createBooking(booking);
            model.addAttribute("booking", createdBooking);
            model.addAttribute("paymentLink", createdBooking.getPayment().getPaymentLink());
            return "booking-success";
        } catch (Exception e) {
            model.addAttribute("error", "Failed to create booking. Please try again.");
            return "booking-form";
        }
    }
    
    @GetMapping("/check-availability")
    @ResponseBody
    public List<Room> checkAvailability(@RequestParam Long guestHouseId,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkIn,
                                      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut) {
        return roomService.getAvailableRooms(guestHouseId, checkIn, checkOut);
    }
}