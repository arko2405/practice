package com.autocomplete.bean;

public class Address {
	private String city;
	private String locality;
	private Integer pin;

	public Address(String city, String locality, Integer pin) {
		super();
		this.city = city;
		this.locality = locality;
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", locality=" + locality + ", pin=" + pin + "]";
	}
	
	

}
