package com.guesthouse.reservation.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;
    
    @NotNull
    @Positive
    private BigDecimal amount;
    
    @NotBlank
    private String paymentMethod;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    
    private String transactionId;
    private String paymentLink;
    private LocalDateTime paymentDate;
    private LocalDateTime createdAt;
    
    // Constructors
    public Payment() {
        this.status = PaymentStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }
    
    public Payment(Booking booking, BigDecimal amount, String paymentMethod) {
        this();
        this.booking = booking;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Booking getBooking() {
        return booking;
    }
    
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public PaymentStatus getStatus() {
        return status;
    }
    
    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
    
    public String getPaymentLink() {
        return paymentLink;
    }
    
    public void setPaymentLink(String paymentLink) {
        this.paymentLink = paymentLink;
    }
    
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }
    
    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}