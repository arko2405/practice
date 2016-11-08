package com.practice.paymentwallet.servicesimpl;

import com.practice.paymentwallet.beans.User;
import com.practice.paymentwallet.services.PaymentService;

public class PaymentServiceImpl implements PaymentService{

	@Override
	public Boolean payMerchant(User customer, User merchant, Double amount) {
		// logic
		return null;
	}

	@Override
	public Boolean refundCustomer(User customer, User merchant, Double amount) {
		// logic
		return null;
	}

	@Override
	public Boolean payToBankAmountFromWallet(User user, Double amount) {
		// logic to transfer to bank amount
		return null;
	}
	
	
}
