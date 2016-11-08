package com.practice.paymentwallet.exceptions;

public class LowBalanceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public LowBalanceException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
