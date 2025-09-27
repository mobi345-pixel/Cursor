package com.guesthouse.reservation.controller;

import com.guesthouse.reservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    
    @Autowired
    private BookingService bookingService;
    
    @GetMapping("/{bookingId}")
    public String showPaymentPage(@PathVariable Long bookingId, 
                                 @RequestParam(required = false) String token,
                                 Model model) {
        var booking = bookingService.getBookingById(bookingId);
        if (booking == null) {
            return "redirect:/";
        }
        
        model.addAttribute("booking", booking);
        model.addAttribute("payment", booking.getPayment());
        return "payment";
    }
    
    @PostMapping("/process/{bookingId}")
    public String processPayment(@PathVariable Long bookingId,
                               @RequestParam String transactionId,
                               Model model) {
        try {
            bookingService.confirmPayment(bookingId, transactionId);
            model.addAttribute("success", "Payment processed successfully!");
            return "payment-success";
        } catch (Exception e) {
            model.addAttribute("error", "Payment processing failed. Please try again.");
            return "payment";
        }
    }
}