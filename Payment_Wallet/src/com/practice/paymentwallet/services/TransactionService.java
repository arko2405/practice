package com.practice.paymentwallet.services;

import java.util.List;

import com.practice.paymentwallet.beans.Transaction;
import com.practice.paymentwallet.beans.User;

public interface TransactionService {
	
	public List<Transaction> getTransactionsByUser(User user);

}
