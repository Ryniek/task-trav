package com.travactory.recruitment.junior.response;

public class FlightDurationResponse {
    private final Long days;
    private final Long hours;
    private final Long minutes;

    public FlightDurationResponse(final Long days, final Long hours, final Long minutes) {
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
    }

    public Long getDays() {
        return days;
    }

    public Long getHours() {
        return hours;
    }

    public Long getMinutes() {
        return minutes;
    }
}
