package com.hotelreservation.beans;

public abstract class Amneties {

	protected String description;
	protected Double cost;
	protected Amneties amneties;

	protected Amneties(String description, Double cost) {
		this.description = description;
		this.cost = cost;
	}
	
	public Amneties(String description, Double cost, Amneties amneties) {
		this.description = description;
		this.cost = cost;
		this.amneties = amneties;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
	public void printAmnetiesRate(){
		amneties.printAmnetiesRate();
		System.out.println(description + " : Rs. " + cost);
	}

}
