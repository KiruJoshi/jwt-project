package com.JWTTest.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JWTTest.MyEntities.Users;
import com.JWTTest.MyServices.UserService;



@RestController
@RequestMapping("/home")
public class HomeControllers {
	
	@Autowired
	
	UserService userService;
	
	
	@GetMapping("/users")
	
	public List<Users> getUser() {
		
		System.out.println("gettomg users");
		return userService.getUsers();
	}
	
@GetMapping("/current-user")
	
	public String getUser(Principal principal) {
		
		System.out.println("gettomg users");
		return principal.getName();
	}
	
	

}
