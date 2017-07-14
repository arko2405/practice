package com.hotelreservation.factories;

import com.hotelreservation.beans.FiveStarHotel;
import com.hotelreservation.beans.Hotel;
import com.hotelreservation.beans.ThreeStarHotel;
import com.hotelreservation.constants.EntityTypeAndIdConstants;

public class HotelFactory {

	public static Hotel getHotel(Integer id) {
		if(id == EntityTypeAndIdConstants.FIVE_STAR_HOTEL_ID)
			return new FiveStarHotel();
		if(id == EntityTypeAndIdConstants.THREE_STAR_HOTEL_ID)
			return new ThreeStarHotel();
		return null;
	}

	public static Hotel getHotel(String type) {

		if(type.equals(EntityTypeAndIdConstants.FIVE_STAR_HOTEL_TYPE))
			return new FiveStarHotel();
		if(type.equals(EntityTypeAndIdConstants.THREE_STAR_HOTEL_TYPE))
			return new ThreeStarHotel();
		return null;
	}

}
