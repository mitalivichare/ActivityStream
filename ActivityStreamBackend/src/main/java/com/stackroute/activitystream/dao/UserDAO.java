package com.stackroute.activitystream.dao;

import java.util.List;

import com.stackroute.activitystream.model.User;

public interface UserDAO 
{
	public boolean createUser(User user);
	public boolean updateUser(User user);
	public User authenticateUser(User user);
	public boolean deleteUser(String emailId);
	public User getUserByUserId(String emailId);
	public List<User> getAllUsers();
	

}
