package com.feed.services;

import com.feed.beans.Post;
import com.feed.beans.User;

public interface PostServices {
	
	public Boolean post(Post post);

	public Boolean notifyObservers(Post post);

	public Boolean deletePost(Post post , User requestedBy);

}
