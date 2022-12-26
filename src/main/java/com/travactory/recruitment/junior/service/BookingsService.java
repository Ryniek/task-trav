package com.travactory.recruitment.junior.service;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.travactory.recruitment.junior.exception.ResourceNotFoundException;
import com.travactory.recruitment.junior.model.Airport;
import com.travactory.recruitment.junior.model.Booking;
import com.travactory.recruitment.junior.model.Customer;
import com.travactory.recruitment.junior.repository.AirportsRepository;
import com.travactory.recruitment.junior.repository.BookingsRepository;
import com.travactory.recruitment.junior.repository.CustomersRepository;
import com.travactory.recruitment.junior.request.NewBookingRequest;
import com.travactory.recruitment.junior.response.BookingPriceResponse;
import com.travactory.recruitment.junior.response.FlightDurationResponse;

@Service
public class BookingsService {

    private BookingsRepository bookingsRepository;
    private AirportsRepository airportRepository;
    private CustomersRepository customerRepository;

    public BookingsService(final BookingsRepository bookingsRepository, AirportsRepository airportRepository, CustomersRepository customerRepository) {
    		this.bookingsRepository = bookingsRepository;
    		this.airportRepository = airportRepository;
    		this.customerRepository = customerRepository;
    }
    
    public List<Booking> getAllBookings() {
    	return bookingsRepository.findAll();
    }

    public Booking getBookingById(final Integer id) {
        return bookingsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking with given id not found"));
    }

    public FlightDurationResponse calculateFlightDuration(final Integer bookingId) {
        final Booking booking = getBookingById(bookingId);

        final Duration duration = Duration.between(
                booking.getDepartureDate().toInstant().minus(booking.getDeparture().getGmtTimeZoneOffset(), ChronoUnit.HOURS),
                booking.getArrivalDate().toInstant().minus(booking.getDestination().getGmtTimeZoneOffset(), ChronoUnit.HOURS));

        return new FlightDurationResponse(
                duration.toDays(),
                duration.toHours() % 24,
                duration.toMinutes() % 60);
    }

    public BookingPriceResponse calculateBookingPrice(final Integer bookingId) {
        final Booking booking = getBookingById(bookingId);

        return new BookingPriceResponse(
                booking.getPassengers(),
                booking.getPassengerPrice(),
                Double.valueOf(booking.getPassengers() * booking.getPassengerPrice()));
    }
    
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Booking addBooking(NewBookingRequest newBookingRequest) {
    	Airport departureAirport = airportRepository
    			.findByCode(newBookingRequest.getDepartureAirportCode())
    			.orElseThrow(() -> new ResourceNotFoundException("Departure airport with given code not found"));
    	Airport destinationAirport = airportRepository
    			.findByCode(newBookingRequest.getDestinationAirportCode())
    			.orElseThrow(() -> new ResourceNotFoundException("Destination airport with given code not found"));
    	Customer customer = customerRepository
    			.findById(newBookingRequest.getCustomerId())
    			.orElseThrow(() -> new ResourceNotFoundException("Customer with given id not found"));
    	
    	Booking newBooking = NewBookingRequest.fromRequestToBooking(departureAirport, destinationAirport, customer, newBookingRequest);
    	
    	return bookingsRepository.save(newBooking);
    }
}
