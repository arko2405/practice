package com.practice.paymentwallet.beans;

public enum Currency {
	INR("Rs","Rupee"), DOLLAR("$","Dollar"), EURO("E", "Euro");

	private String symbol;
	private String name;
	
	private Currency(String symbol, String name) {
	       this.symbol = symbol;
	       this.name = name;
	   }

	public static Currency getCurrencyBySymbol(String symbol) {
		for (Currency currency : Currency.values()) {
			if (currency.symbol.equals(symbol)) {
				return currency;
			}
		}
		return null;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

}
