package com.practice.paymentwallet.beans;

import com.practice.paymentwallet.exceptions.LowBalanceException;

public class CurrencyPockets {
	
	private Currency currency;
	private Double balance;
	
	public CurrencyPockets(Currency currency, Double balance) {
		this.currency = currency;
		this.balance = balance;
	}
	public CurrencyPockets(Currency currency) {
		this(currency,0.0);
	}

	public CurrencyPockets() {
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getBalance() {
		return balance;
	}

	public void addToBalance(Double balance) {
		this.balance += balance;
	}
	
	public void deductFromBalance(Double balance) {
		if(this.balance < balance)
			throw new LowBalanceException("Please Add Money To wallet");
		this.balance -= balance;
	}
	
}
