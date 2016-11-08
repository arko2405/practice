package com.feed.beans;


public enum UserType {
	
	REGULAR_USER(1), ADMIN(2), PAGE(3);

	private Integer userTypeId;

	private UserType(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public static UserType getUserTypeById(Integer id) {
		for (UserType userType : UserType.values()) {
			if (userType.userTypeId == id) {
				return userType;
			}
		}
		return null;
	}


	public Integer getUserTypeId() {
		return userTypeId;
	}


}
