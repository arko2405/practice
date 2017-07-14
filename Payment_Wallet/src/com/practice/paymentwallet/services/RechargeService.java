package com.practice.paymentwallet.services;

import com.practice.paymentwallet.beans.User;

public interface RechargeService {
	
	public Boolean rechargeWallet(User user, Double amount);

}
