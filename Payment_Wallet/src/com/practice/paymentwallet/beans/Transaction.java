package com.practice.paymentwallet.beans;

import java.util.Date;

public class Transaction {
	private Long id;
	private User paidBy;
	private User paidTo;
	private Double amount;
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getPaidBy() {
		return paidBy;
	}

	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}

	public User getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(User paidTo) {
		this.paidTo = paidTo;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
