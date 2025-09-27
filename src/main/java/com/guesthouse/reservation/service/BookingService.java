package com.guesthouse.reservation.service;

import com.guesthouse.reservation.model.Booking;
import com.guesthouse.reservation.model.BookingStatus;
import com.guesthouse.reservation.model.Payment;
import com.guesthouse.reservation.model.PaymentStatus;
import com.guesthouse.reservation.repository.BookingRepository;
import com.guesthouse.reservation.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private PaymentRepository paymentRepository;
    
    @Autowired
    private EmailService emailService;
    
    public Booking createBooking(Booking booking) {
        // Calculate total amount
        long nights = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
        booking.setTotalAmount(booking.getRoom().getPricePerNight().multiply(BigDecimal.valueOf(nights)));
        
        // Save booking
        Booking savedBooking = bookingRepository.save(booking);
        
        // Create payment
        Payment payment = new Payment(savedBooking, savedBooking.getTotalAmount(), "ONLINE");
        payment.setPaymentLink(generatePaymentLink(savedBooking.getId()));
        paymentRepository.save(payment);
        
        savedBooking.setPayment(payment);
        
        return savedBooking;
    }
    
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElse(null);
    }
    
    public List<Booking> getBookingsByRoom(Long roomId) {
        return bookingRepository.findByRoomId(roomId);
    }
    
    public boolean isRoomAvailable(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Booking> conflictingBookings = bookingRepository.findConflictingBookings(roomId, checkInDate, checkOutDate);
        return conflictingBookings.isEmpty();
    }
    
    public void confirmPayment(Long bookingId, String transactionId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null && booking.getPayment() != null) {
            Payment payment = booking.getPayment();
            payment.setStatus(PaymentStatus.COMPLETED);
            payment.setTransactionId(transactionId);
            payment.setPaymentDate(java.time.LocalDateTime.now());
            paymentRepository.save(payment);
            
            booking.setStatus(BookingStatus.CONFIRMED);
            bookingRepository.save(booking);
            
            // Send confirmation email
            emailService.sendBookingConfirmation(booking);
        }
    }
    
    private String generatePaymentLink(Long bookingId) {
        String baseUrl = "http://localhost:8080/payment/";
        String token = UUID.randomUUID().toString();
        return baseUrl + bookingId + "?token=" + token;
    }
}