package net.codejava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.model.Users;
import net.codejava.services.UsersService;

@RestController
public class AppController {



	@Autowired
	private UsersService us;
	
	@PostMapping("/adduser")
	public Users addUser(@RequestBody Users u)
	{
		if(u.isSendEmail()) {
			System.out.println("email logged in");
			us.notificationModeEmail(u);
			
		}
		if(u.isSendViaMessage()) {
			System.out.println("text logged in");
			us.notificationModeMessage(u);
		}
		if(u.isCall()) {
			System.out.println("calling the user");
			us.notificationModeCall(u);
			
		}
		
		return this.us.addUser(u);
	}
	
	@GetMapping("/getuser")
	 public List<Users> getUser()
	{
		return this.us.getUser();
	}
}