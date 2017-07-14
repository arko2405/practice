package com.hotelreservation.services;

import com.hotelreservation.beans.Guest;

public interface PaymentService {
	
	public Boolean payBill(Guest guest);
	
	public Boolean refundCustomer(Guest guest , Double amount);
	
}
