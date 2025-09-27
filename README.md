# Guest House Reservation System

A comprehensive web-based reservation system for guest houses located in four major cities of Pakistan: Rawalpindi, Murree, Nathia Gali, and Lahore.

## Features

### 🏠 City Selection
- Browse guest houses by city
- Easy navigation between different locations
- Responsive city cards with hover effects

### 🏨 Guest House Management
- Detailed guest house listings for each city
- Room availability and capacity information
- Amenities and descriptions for each property

### 📅 Room Booking System
- Real-time room availability checking
- Date picker for check-in and check-out dates
- Room details with pricing and capacity

### 👤 Guest Information
- Comprehensive booking form
- Guest details collection (name, email, phone, address)
- Number of guests selection
- Special requests handling

### 💳 Payment Processing
- Secure payment link generation
- Multiple payment methods support
- Transaction ID verification
- Payment confirmation system

### 📧 Email Notifications
- Automatic booking confirmation emails
- Payment success notifications
- Professional email templates

## Technology Stack

### Backend
- **Java 17** - Programming language
- **Spring Boot 3.2.0** - Application framework
- **Spring Data JPA** - Data persistence
- **Spring Mail** - Email functionality
- **H2 Database** - In-memory database for development
- **Thymeleaf** - Server-side template engine

### Frontend
- **HTML5** - Markup language
- **CSS3** - Styling with modern features
- **JavaScript** - Client-side interactivity
- **Font Awesome** - Icons
- **Responsive Design** - Mobile-friendly interface

### Development Tools
- **Maven** - Build tool
- **Spring Boot DevTools** - Development utilities
- **H2 Console** - Database management

## Project Structure

```
src/
├── main/
│   ├── java/com/guesthouse/reservation/
│   │   ├── config/
│   │   │   └── DataInitializer.java
│   │   ├── controller/
│   │   │   ├── BookingController.java
│   │   │   ├── HomeController.java
│   │   │   └── PaymentController.java
│   │   ├── model/
│   │   │   ├── Booking.java
│   │   │   ├── BookingStatus.java
│   │   │   ├── City.java
│   │   │   ├── GuestHouse.java
│   │   │   ├── Payment.java
│   │   │   ├── PaymentStatus.java
│   │   │   └── Room.java
│   │   ├── repository/
│   │   │   ├── BookingRepository.java
│   │   │   ├── CityRepository.java
│   │   │   ├── GuestHouseRepository.java
│   │   │   ├── PaymentRepository.java
│   │   │   └── RoomRepository.java
│   │   ├── service/
│   │   │   ├── BookingService.java
│   │   │   ├── CityService.java
│   │   │   ├── EmailService.java
│   │   │   ├── GuestHouseService.java
│   │   │   └── RoomService.java
│   │   └── GuestHouseReservationApplication.java
│   └── resources/
│       ├── static/
│       │   ├── css/
│       │   │   └── style.css
│       │   └── js/
│       │       └── main.js
│       ├── templates/
│       │   ├── booking-form.html
│       │   ├── booking-success.html
│       │   ├── city-guesthouses.html
│       │   ├── guesthouse-details.html
│       │   ├── index.html
│       │   ├── payment.html
│       │   └── payment-success.html
│       └── application.properties
└── pom.xml
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Internet connection (for downloading dependencies)

### Installation

1. **Clone or download the project**
   ```bash
   # If using git
   git clone <repository-url>
   cd guest-house-reservation-system
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Open your browser and navigate to `http://localhost:8080`
   - The application will be running on port 8080

### Database Access
- H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:guesthouse`
- Username: `sa`
- Password: `password`

## Usage Guide

### 1. Browse Cities
- Visit the homepage to see all available cities
- Click on any city card to view guest houses in that location

### 2. Select Guest House
- Browse through available guest houses in your chosen city
- Click "View Details" to see more information about a specific guest house

### 3. Check Room Availability
- On the guest house details page, select your check-in and check-out dates
- Click "Check Availability" to see available rooms
- View room details including pricing and capacity

### 4. Book a Room
- Click "Book This Room" on your preferred room
- Fill in the booking form with your details:
  - Full name
  - Email address
  - Phone number
  - Address
  - Number of guests
  - Special requests (optional)

### 5. Complete Payment
- Review your booking summary
- Click "Pay Now" to proceed to payment
- Choose your payment method
- Enter transaction ID after completing payment
- Click "Confirm Payment"

### 6. Receive Confirmation
- After successful payment, you'll see a confirmation page
- Check your email for booking confirmation
- Print the confirmation for your records

## Sample Data

The application comes pre-loaded with sample data:

### Cities
- Rawalpindi
- Murree
- Nathia Gali
- Lahore

### Guest Houses
Each city has 2 guest houses with different amenities and room types.

### Rooms
- Standard Rooms (2 guests)
- Deluxe Rooms (3 guests)
- Family Rooms (4 guests)
- Executive Rooms (2 guests)

## Configuration

### Email Configuration
To enable email notifications, update the email settings in `application.properties`:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### Database Configuration
For production, replace H2 with a persistent database:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/guesthouse
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

## API Endpoints

### Web Pages
- `GET /` - Homepage with city selection
- `GET /city/{cityName}` - Guest houses in specific city
- `GET /guesthouse/{id}` - Guest house details and rooms
- `GET /booking/room/{roomId}` - Booking form
- `GET /payment/{bookingId}` - Payment page

### API Endpoints
- `POST /booking/create` - Create new booking
- `POST /payment/process/{bookingId}` - Process payment
- `GET /booking/check-availability` - Check room availability

## Features Implemented

✅ **City Selection** - Browse guest houses by city  
✅ **Guest House Listing** - View available properties  
✅ **Room Availability** - Check room availability with calendar  
✅ **Booking System** - Complete booking process  
✅ **Payment Processing** - Secure payment handling  
✅ **Email Notifications** - Automatic confirmations  
✅ **Responsive Design** - Mobile-friendly interface  
✅ **Modern UI** - Beautiful and intuitive design  

## Future Enhancements

- User authentication and accounts
- Advanced search and filtering
- Real-time availability updates
- Integration with payment gateways
- Admin panel for management
- Mobile app development
- Multi-language support
- Review and rating system

## Troubleshooting

### Common Issues

1. **Port already in use**
   - Change the port in `application.properties`: `server.port=8081`

2. **Email not working**
   - Check email configuration in `application.properties`
   - Ensure SMTP credentials are correct

3. **Database connection issues**
   - Verify H2 console access
   - Check database configuration

4. **Static resources not loading**
   - Clear browser cache
   - Check if CSS/JS files are in correct locations

## Support

For issues or questions:
1. Check the troubleshooting section
2. Review the application logs
3. Verify configuration settings
4. Test with sample data

## License

This project is created for educational and demonstration purposes.

---

**Guest House Reservation System** - Making accommodation booking simple and efficient across Pakistan's beautiful cities.