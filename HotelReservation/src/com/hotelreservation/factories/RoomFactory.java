package com.hotelreservation.factories;

import com.hotelreservation.beans.DoubleRoom;
import com.hotelreservation.beans.Room;
import com.hotelreservation.beans.SingleRoom;
import com.hotelreservation.constants.EntityTypeAndIdConstants;

public class RoomFactory {
	
	public static Room getRoom(Integer id) {
		if(id == EntityTypeAndIdConstants.SINGLE_ROOM_ID)
			return new SingleRoom();
		if(id == EntityTypeAndIdConstants.DOUBLE_ROOM_ID)
			return new DoubleRoom();
		return null;
	}

	public static Room getRoom(String type) {

		if(type.equals(EntityTypeAndIdConstants.SINGLE_ROOM_TYPE))
			return new SingleRoom();
		if(type.equals(EntityTypeAndIdConstants.DOUBLE_ROOM_TYPE))
			return new DoubleRoom();
		return null;
	}

}
