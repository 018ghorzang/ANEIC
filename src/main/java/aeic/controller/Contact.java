package aeic.controller;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import aeic.model.Authentication;
import aeic.model.MessageTable;
import aeic.model.User;
import aeic.services.ContactService;
import aeic.services.UserServices;

@Controller
public class Contact {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private UserServices userServices;

	
	
	
	@GetMapping("/contact")
	public String getAbout(Model model) {
		
		List<User> getUsers = userServices.getUser();
		
		model.addAttribute("users",getUsers);
		model.addAttribute("userCount",userServices.getUserCount());
		
	  System.out.print("This is the user number: " + userServices.getUserCount());
	
		
//		List<Authentication> getAuth = contactService.getAuthentication();
//		model.addAttribute("auth",getAuth);
		return "contact"; 
	}
	
	@PostMapping("/contact/addMessage")
	public String saveMessage(Authentication auth, MessageTable message) {
		
	    message.setDate(new Date());
		contactService.saveMessage(message);
		return "redirect:/contact";
	}
	

}
