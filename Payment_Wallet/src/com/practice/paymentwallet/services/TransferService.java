package com.practice.paymentwallet.services;

import com.practice.paymentwallet.beans.User;

public interface TransferService {
	
	public Boolean transferToWallet(User from , User to , Double amount);

}
