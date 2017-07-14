package com.practice.paymentwallet.servicesimpl;

import com.practice.paymentwallet.beans.Currency;
import com.practice.paymentwallet.beans.User;
import com.practice.paymentwallet.services.ConversionService;

public class ConversionServiceImpl implements ConversionService{

	@Override
	public Boolean getExchangeAmount(Currency from, Currency to, Double amount) {
		// logic calling external api
		return null;
	}

	@Override
	public Boolean transferFromOneCurrencyPocketToOther(User user, Currency from, Currency to) {
		// logic
		return null;
	}

}
