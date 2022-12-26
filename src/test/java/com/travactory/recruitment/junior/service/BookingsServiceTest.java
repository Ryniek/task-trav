package com.travactory.recruitment.junior.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.travactory.recruitment.junior.exception.ResourceNotFoundException;
import com.travactory.recruitment.junior.model.Booking;
import com.travactory.recruitment.junior.repository.BookingsRepository;
import com.travactory.recruitment.junior.response.BookingPriceResponse;

@RunWith(SpringRunner.class)
public class BookingsServiceTest {
	
	@InjectMocks private BookingsService bookingsService;
	@Mock private BookingsRepository bookingsRepository;

	@Test
	public void shouldCalculateBookingPrice() {
		//given
		Booking booking = prepDummyBooking();
		when(bookingsRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(booking));
		//when
		BookingPriceResponse response = bookingsService.calculateBookingPrice(Mockito.anyInt());
		//then
		assertEquals(240.4, response.getTotalPrice(), 0);
		assertNotEquals(240, response.getTotalPrice(), 0);
	}

	@Test
	public void shouldThrowBookingNotFoundWhenCalculateBookingPrice() {
		when(bookingsRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

		assertThatThrownBy(() -> bookingsService.calculateBookingPrice(Mockito.anyInt()))
			.isInstanceOf(ResourceNotFoundException.class);
	}
	
	private Booking prepDummyBooking() {
		Booking booking = new Booking();
		booking.setPassengers(2);
		booking.setPassengerPrice(120.2);
		return booking;
	}
}
