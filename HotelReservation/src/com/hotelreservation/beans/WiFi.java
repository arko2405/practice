package com.hotelreservation.beans;

public class WiFi extends Amneties {

	public WiFi(Double cost) {
		this(new NoAmneties(),cost);
	}

	public WiFi(Amneties amneties, Double cost) {
		super("Wi-Fi", cost,amneties);
		this.cost =  this.cost + amneties.getCost();
		this.description = this.description + amneties.getDescription();
	}

}
