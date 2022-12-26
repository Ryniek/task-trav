package com.travactory.recruitment.junior.response;

public class BookingPriceResponse {
    private Integer passengers;
    private Double passengerPrice;
    private Double totalPrice;

    public BookingPriceResponse(Integer passengers, Double passengerPrice, Double totalPrice) {
        this.passengers = passengers;
        this.passengerPrice = passengerPrice;
        this.totalPrice = totalPrice;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public Double getPassengerPrice() {
        return passengerPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }
}
