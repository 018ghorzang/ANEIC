package aeic.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aeic.controller.Authentication_Provider;
import aeic.model.User;
import aeic.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	UserRepository userRepository;
	

	
	public List<User> getUser(){
		return  userRepository.findAll();
	}
	
	public long getUserCount() {
		return userRepository.count();
	}
	
	public User getUserByEmail(String  email) {
		return userRepository.getUserByEmail(email);
	}

	public User getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}
	

	public void createNewUserAfterOAuthLoginSuccess(String email, String name,
			Authentication_Provider provider) {
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setUsername(email);
//		user.setPassword(null);
		user.setAuthentication_Provider(provider);
		
		userRepository.save(user);
		System.out.println( "Successful Save : ");
	}


	public void updateUserAfterOAuthLoginSuccess(User user, String name, Authentication_Provider google) {
	
		user.setName(name);
		user.setAuthentication_Provider(google);
		
		userRepository.save(user);
		
	}

	public void delete(Integer id) {
		userRepository.deleteById(id);
		
	}
	 
	
	
	
	
}
