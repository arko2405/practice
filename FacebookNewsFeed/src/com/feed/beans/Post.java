package com.feed.beans;

import java.util.Date;
import java.util.Map;

public class Post {
	
	protected Integer postId;
	protected String subject;
	protected String post;
	protected User postedBy;
	protected Map<User,Boolean> usersWithAdminRights;
	protected Date postedOn;

}
