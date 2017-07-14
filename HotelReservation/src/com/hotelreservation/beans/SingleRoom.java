package com.hotelreservation.beans;

import com.hotelreservation.constants.EntityTypeAndIdConstants;

public class SingleRoom extends Room {

	public SingleRoom() {
		roomTypeId = EntityTypeAndIdConstants.SINGLE_ROOM_ID;
		roomType = EntityTypeAndIdConstants.SINGLE_ROOM_TYPE;
	}

	
}
