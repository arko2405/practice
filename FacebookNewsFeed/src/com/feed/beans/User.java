package com.feed.beans;

import java.util.List;

public abstract class User {

	protected Integer userId;
	protected String email;
	protected String password;
	protected Profile profile;
	protected List<User> friends;
	protected List<User> observers;
	protected List<Post> myPosts;
	protected List<Post> feed;
	protected UserType userType;
	
	public User(UserType userType) {
		this.userType = userType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getObservers() {
		return observers;
	}

	public void setObservers(List<User> observers) {
		this.observers = observers;
	}

	public void addObserver(User observer) {
		this.observers.add(observer);
	}

	public void addFriend(User friend) {
		this.friends.add(friend);
	}

	public List<Post> getMyPosts() {
		return myPosts;
	}

	public void setMyPosts(List<Post> myPosts) {
		this.myPosts = myPosts;
	}

	public List<Post> getFeed() {
		return feed;
	}

	public void setFeed(List<Post> feed) {
		this.feed = feed;
	}

}
