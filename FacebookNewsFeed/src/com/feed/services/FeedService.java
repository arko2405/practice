package com.feed.services;

import java.util.List;

import com.feed.beans.Post;
import com.feed.beans.User;

public interface FeedService {
	
	public List<Post> getfeed(User user);

}
