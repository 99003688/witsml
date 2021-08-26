package net.codejava.services;

import java.util.List;

import net.codejava.model.Users;

public interface UsersService {

	public Users addUser(Users user);
	
	public List<Users> getUser();
	
	public void notificationModeEmail(Users user);
	
	public void notificationModeMessage(Users user);
	
	public void notificationModeCall(Users user);
	
}

 
