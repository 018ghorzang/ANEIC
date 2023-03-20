package aeic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import aeic.model.MessageTable;
import aeic.model.NewsModel;
import aeic.services.ContactService;
import aeic.services.NewsServices;

@Controller
public class MainController {
	
	
	@Autowired
	NewsServices newsServices;
	
	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String getIndex(Model model) {
		
		/* RETRIVE THE NEWS DATA FORM DB */
		
		List<NewsModel> getNews = newsServices.getAll();
		
		model.addAttribute("getNews",getNews);
		
		
		return "index";
	}
	
	
	/* THIS IS FOR PHOTO REQUESTE*/
	
	@GetMapping("/photo")
	public String getPhoto(Model model) {
		
        /* RETRIVE THE ALL PHOTO DATA FORM DB */
		List<NewsModel> getPhoto = newsServices.getAll();
		model.addAttribute("getPhoto",getPhoto);
		
		return "gallery";
	}
	

  /* THIS IS FOR GRANTED LICENSE REQUEST */	
	@GetMapping("/license")
	public String getGrantedLicense() {
		return "license";
	}
	
	  /* THIS IS FOR USER MESSAGES */	
		@GetMapping("user_message")
		public String getUserMessages(Model model) {
			
			List<MessageTable> getMessage = contactService.getMessage();
			model.addAttribute("message",getMessage);
			return "user_message";
		}
}
