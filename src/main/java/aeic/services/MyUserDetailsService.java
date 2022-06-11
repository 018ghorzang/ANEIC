package aeic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import aeic.controller.UserPrincipal;
import aeic.model.User;
import aeic.repository.UserRepository;
import aeic.roles.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.getUserByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("404");
		}
		
	   return new MyUserDetails(user);
	}
	

	
    }
