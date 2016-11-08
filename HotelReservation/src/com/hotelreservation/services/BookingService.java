package com.hotelreservation.services;


import com.hotelreservation.beans.Booking;

public interface BookingService {
	
	public Boolean bookRooms(Booking booking);

	public Boolean cancelBooking(Booking booking);
	
	public Boolean completeBookingAfterPeriod(Booking booking);

}
