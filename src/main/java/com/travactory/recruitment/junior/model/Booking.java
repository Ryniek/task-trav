package com.travactory.recruitment.junior.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departure;
    @ManyToOne
    @JoinColumn(name = "destination_airport_id", nullable = false)
    private Airport destination;
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date departureDate;
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Date arrivalDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @Column(columnDefinition = "DECIMAL")
    private Double passengerPrice;
    @Column(nullable = false)
    private Integer passengers;
    @Column(columnDefinition = "VARCHAR(1)")
    private String classType;

    public Integer getId() {
        return id;
    }

    public Airport getDeparture() {
        return departure;
    }
    
	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

    public Airport getDestination() {
        return destination;
    }
    
	public void setDestination(Airport destination) {
		this.destination = destination;
	}

    public Date getDepartureDate() {
        return departureDate;
    }
    
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

    public Date getArrivalDate() {
        return arrivalDate;
    }
    
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

    public Customer getCustomer() {
        return customer;
    }
    
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    public Double getPassengerPrice() {
        return passengerPrice;
    }
    
	public void setPassengerPrice(Double passengerPrice) {
		this.passengerPrice = passengerPrice;
	}

    public Integer getPassengers() {
        return passengers;
    }

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}
	
    public String getClassType() {
        String classTypeFullName;
        switch (classType) {
            case "F":
                classTypeFullName = "First";
                break;
            case "E":
                classTypeFullName = "Economy";
                break;
            case "B":
                classTypeFullName = "Business";
                break;
            default:
                classTypeFullName = "Unknown class " + classType;

        }
        return classTypeFullName;
    }

	public void setClassType(String classType) {
		this.classType = classType;
	}
    
    
}
