package com.ahmedeid.securityandjwt.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ahmedeid.securityandjwt.demo.entities.User;
import com.ahmedeid.securityandjwt.demo.services.UserService;

@Component
public class FirstTimeInitializer implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		if(this.userService.getAll().isEmpty()) {
			System.out.println("LOG:  we will create new user now ");
			User user = new User("Baker Ibrahem" , "Baker@gmail.com" , "123456");
			this.userService.saveUser(user);
			System.out.println("LOG:  you have new user : \n"+user);
		} else {
			System.out.println("LOG: we have found some users in DB");
		}
		
	}

}
