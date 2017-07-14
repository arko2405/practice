package com.practice.paymentwallet.services;

import com.practice.paymentwallet.beans.User;

public interface PaymentService {
	
	public Boolean payMerchant(User customer , User merchant , Double amount);
	
	public Boolean refundCustomer(User customer , User merchant , Double amount);
	
	public Boolean payToBankAmountFromWallet(User user ,Double amount);
	
}
