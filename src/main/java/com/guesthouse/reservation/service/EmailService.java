package com.guesthouse.reservation.service;

import com.guesthouse.reservation.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    public void sendBookingConfirmation(Booking booking) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(booking.getGuestEmail());
        message.setSubject("Booking Confirmation - Guest House Reservation");
        
        String emailBody = String.format(
            "Dear %s,\n\n" +
            "Your booking has been confirmed!\n\n" +
            "Booking Details:\n" +
            "Guest House: %s\n" +
            "Room: %s (%s)\n" +
            "Check-in: %s\n" +
            "Check-out: %s\n" +
            "Number of Guests: %d\n" +
            "Total Amount: $%.2f\n\n" +
            "Thank you for choosing our guest house!\n\n" +
            "Best regards,\n" +
            "Guest House Management Team",
            booking.getGuestName(),
            booking.getRoom().getGuestHouse().getName(),
            booking.getRoom().getRoomNumber(),
            booking.getRoom().getRoomType(),
            booking.getCheckInDate(),
            booking.getCheckOutDate(),
            booking.getNumberOfGuests(),
            booking.getTotalAmount()
        );
        
        message.setText(emailBody);
        mailSender.send(message);
    }
}