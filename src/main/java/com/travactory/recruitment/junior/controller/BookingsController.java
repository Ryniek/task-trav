package com.travactory.recruitment.junior.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travactory.recruitment.junior.model.Booking;
import com.travactory.recruitment.junior.request.NewBookingRequest;
import com.travactory.recruitment.junior.response.BookingPriceResponse;
import com.travactory.recruitment.junior.response.FlightDurationResponse;
import com.travactory.recruitment.junior.service.BookingsService;

@RestController
@Validated
@RequestMapping("/api/bookings")
public class BookingsController {

    private BookingsService bookingsService;

    public BookingsController(final BookingsService bookingsService) {this.bookingsService = bookingsService;}
    
    @GetMapping
    public ResponseEntity<?> getAllBookings() {
    	final List<Booking> bookings = bookingsService.getAllBookings();
    	return ResponseEntity.ok(bookings);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBookingById(@PathVariable(name = "id") final Integer id) {
        final Booking booking = bookingsService.getBookingById(id);
        return ResponseEntity.ok(booking);
    }

    @GetMapping("{id}/duration")
    public ResponseEntity<?> calculateDuration(@PathVariable(name = "id") final Integer id) {
        final FlightDurationResponse flightDuration = bookingsService.calculateFlightDuration(id);
        return ResponseEntity.ok(flightDuration);
    }

    @GetMapping("{id}/price")
    public ResponseEntity<?> calculatePrice(@PathVariable(name = "id") final Integer id) {
        final BookingPriceResponse bookingPrice = bookingsService.calculateBookingPrice(id);
        return ResponseEntity.ok(bookingPrice);
    }
    
    @PostMapping
    public ResponseEntity<?> addBooking(@Valid @RequestBody NewBookingRequest newBookingRequest, BindingResult result) {
    	//if(result.hasErrors()) throw new ConstraintViolationException(null);
    	final Booking booking = bookingsService.addBooking(newBookingRequest);
    	return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }
}
