package com.JWTTest.MyServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.JWTTest.MyEntities.Users;
import com.JWTTest.MyRepository.UserRepository;
import java.util.UUID;

@Service
public class UserService {


	@Autowired
	private PasswordEncoder passwordEncoder;
	

/*	public UserService() {

		store.add(new Users(UUID.randomUUID().toString(), "Durgesh", "durgesh@dev.in"));
		store.add(new Users(UUID.randomUUID().toString(), "Harsh Tiwary", "harsh@dev.in"));
		store.add(new Users(UUID.randomUUID().toString(), "Ankit tiwary", "ankit@dev.in"));
		store.add(new Users(UUID.randomUUID().toString(), "Gautam Shukla", "gautam@dev.in"));

	}

	public List<Users> getUsers() {

		return this.store;
	}*/
	@Autowired
	private UserRepository userRepository;

public List<Users> getUsers(){
		
		return userRepository.findAll();
	}
	
	public Users createUser(Users user) {
		
		
		user.setUserId(UUID.randomUUID().toString());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
