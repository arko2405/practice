package com.practice.paymentwallet.services;

import com.practice.paymentwallet.beans.Currency;
import com.practice.paymentwallet.beans.User;

public interface ConversionService {
	
	public Boolean getExchangeAmount(Currency from , Currency to , Double amount);
	
	public Boolean transferFromOneCurrencyPocketToOther(User user , Currency from , Currency to);
	
}
