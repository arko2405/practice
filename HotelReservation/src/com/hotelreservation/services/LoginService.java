package com.hotelreservation.services;

import com.hotelreservation.beans.Guest;

public interface LoginService {
	
	public Boolean authenticateUser(Guest guest);
	
}
