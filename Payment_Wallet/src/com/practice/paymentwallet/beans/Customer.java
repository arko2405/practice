package com.practice.paymentwallet.beans;

public class Customer extends User{

	protected Customer(Long id, String name, String email, String password) {
		super(id, name, email, password);
		wallet = new CustomerWallet();
	}

}
