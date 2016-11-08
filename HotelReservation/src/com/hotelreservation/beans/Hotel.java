package com.hotelreservation.beans;

import java.util.List;

public class Hotel {

	protected Long id;
	protected String name;
	protected HotelChain associatedHotelChain;
	protected Double basePrice;
	protected Integer hotelTypeId;
	protected String hotelType;
	protected List<Room> availbleRooms;
	protected Amneties baseAmnety;
	protected Double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HotelChain getAssociatedHotelChain() {
		return associatedHotelChain;
	}

	public void setAssociatedHotelChain(HotelChain associatedHotelChain) {
		this.associatedHotelChain = associatedHotelChain;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public Integer getHotelTypeId() {
		return hotelTypeId;
	}

	public void setHotelTypeId(Integer hotelTypeId) {
		this.hotelTypeId = hotelTypeId;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public List<Room> getRooms() {
		return availbleRooms;
	}

	public void setRooms(List<Room> rooms) {
		this.availbleRooms = rooms;
	}

	public Amneties getBaseAmnety() {
		return baseAmnety;
	}

	public void setBaseAmnety(Amneties baseAmnety) {
		this.baseAmnety = baseAmnety;
	}

	
	public void printRate() {
		System.out.println(name + " base : Rs. " + price);
		baseAmnety.printAmnetiesRate();
	}
	
	public Double getTotalHotelRate() {
		return price + baseAmnety.getCost() ;
	}

}
