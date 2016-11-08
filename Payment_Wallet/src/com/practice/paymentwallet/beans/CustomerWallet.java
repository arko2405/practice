package com.practice.paymentwallet.beans;

import com.practice.paymentwallet.exceptions.LowBalanceException;

public class CustomerWallet extends Wallet {

	@Override
	public void addBalance(Currency currency, Double amount) {
		if (!this.currencyPockets.containsKey(currency))
			addCurrencyPocket(currency);
		this.currencyPockets.get(currency).addToBalance(amount);
	}

	@Override
	public void deductBalance(Currency currency, Double amount) {
		if (!this.currencyPockets.containsKey(currency))
			throw new LowBalanceException("Please add balance to wallet");
		this.currencyPockets.get(currency).addToBalance(amount);
	}

}
