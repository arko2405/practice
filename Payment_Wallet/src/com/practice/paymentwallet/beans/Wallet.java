package com.practice.paymentwallet.beans;

import java.util.HashMap;
import java.util.Map;


public abstract class Wallet {

	protected Map<Currency, CurrencyPockets> currencyPockets;

	protected Wallet() {
		this.currencyPockets = new HashMap<>();
	}

	public Map<Currency, CurrencyPockets> getCurrencyPockets() {
		return currencyPockets;
	}

	public void addCurrencyPocket(Currency currency) {
		this.currencyPockets.put(currency, new CurrencyPockets(currency));
	}

	public abstract void addBalance(Currency currency, Double amount);

	public abstract void deductBalance(Currency currency, Double amount);

}
