package com.practice.paymentwallet.beans;

public class Merchant extends User{

	protected Merchant(Long id, String name, String email, String password) {
		super(id, name, email, password);
		wallet =  new MerchantWallet();
	}
	
}
