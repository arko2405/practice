package com.hotelreservation.services;

import java.util.Date;
import java.util.List;

import com.hotelreservation.beans.Hotel;
import com.hotelreservation.beans.Room;

public interface HotelServices {
	
	public List<Room> getAvailableRooms(Hotel hotel , Date to , Date from);

	public List<Room> getAvailableRoomsByType(Hotel hotel , Date to , Date from , Room type);
}
