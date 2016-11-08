package com.hotelreservation.beans;

public abstract class Room {

	protected Long id;
	protected String roomNo;
	protected Hotel associatedHotel;
	protected Integer roomTypeId;
	protected String roomType;
	protected Double price;
	protected Boolean booked;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public Hotel getAssociatedHotel() {
		return associatedHotel;
	}

	public void setAssociatedHotel(Hotel associatedHotel) {
		this.associatedHotel = associatedHotel;
	}

	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Boolean getBooked() {
		return booked;
	}

	public void setBooked(Boolean booked) {
		this.booked = booked;
	}

	public void printPrice() {
		System.out.println("Room no. " + roomNo + " : Rs. " + price);
	}

}
