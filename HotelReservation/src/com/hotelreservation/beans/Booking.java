package com.hotelreservation.beans;

import java.util.Date;
import java.util.List;

public class Booking {

	private Long id;
	private Guest guest;
	private List<Room> bookedRooms;
	private Amneties addOnAmnetiesRequested;
	private Hotel hotel;
	private Double totalBill;
	private Date from;
	private Date to;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public List<Room> getBookedRooms() {
		return bookedRooms;
	}

	public void setBookedRooms(List<Room> bookedRooms) {
		this.bookedRooms = bookedRooms;
	}

	public Amneties getAddOnAmnetiesRequested() {
		return addOnAmnetiesRequested;
	}

	public void setAddOnAmnetiesRequested(Amneties addOnAmnetiesRequested) {
		this.addOnAmnetiesRequested = addOnAmnetiesRequested;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
	
	public void calculateTotalBill() {
		this.totalBill = hotel.getTotalHotelRate() + addOnAmnetiesRequested.getCost();
		for (Room room : bookedRooms) {
			this.totalBill += room.getPrice();
		}
	}
	
	public void printTotalBill() {
		hotel.printRate();
		addOnAmnetiesRequested.printAmnetiesRate();
		for (Room room : bookedRooms) {
			room.printPrice();
		}
	}

}
