package com.travactory.recruitment.junior.request;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.travactory.recruitment.junior.model.Airport;
import com.travactory.recruitment.junior.model.Booking;
import com.travactory.recruitment.junior.model.Customer;

public class NewBookingRequest {
	@NotEmpty
	private String departureAirportCode;
	@NotEmpty
	private String destinationAirportCode;
	@NotNull
	@Future
	private Date departureDate;
	@NotNull
	@Future
	private Date arrivalDate;
	@NotNull
	private Integer customerId;
	@DecimalMin(value = "0.00")
	@NotNull
	private Double passengerPrice;
	@Min(1)
	@NotNull
	private Integer passengers;
	@NotEmpty
	@Size(max = 1)
	private String classType;
	
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	
	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}
	
	public Date getDepartureDate() {
		return departureDate;
	}
	
	public Date getArrivalDate() {
		return arrivalDate;
	}
	
	public Integer getCustomerId() {
		return customerId;
	}
	
	public Double getPassengerPrice() {
		return passengerPrice;
	}
	
	public Integer getPassengers() {
		return passengers;
	}
	
	public String getClassType() {
		return classType;
	}
	
	public static Booking fromRequestToBooking(Airport departureAirport, Airport destinationAirport, Customer customer, NewBookingRequest request) {
		Booking result = new Booking();
		result.setDeparture(departureAirport);
		result.setDestination(destinationAirport);
		result.setCustomer(customer);
		result.setDepartureDate(request.getDepartureDate());
		result.setArrivalDate(request.getArrivalDate());
		result.setPassengerPrice(request.getPassengerPrice());
		result.setPassengers(request.getPassengers());
		result.setClassType(request.getClassType());
		return result;
	}
}
