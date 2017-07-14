package com.hotelreservation.beans;

public class SwimmingPool extends Amneties {

	public SwimmingPool(Double cost) {
		this(new NoAmneties(),cost);
	}

	public SwimmingPool(Amneties amneties, Double cost) {
		super("Wi-Fi", cost,amneties);
		this.cost =  this.cost + amneties.getCost();
		this.description = this.description + amneties.getDescription();
	}

}
