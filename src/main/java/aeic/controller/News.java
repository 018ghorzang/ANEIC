package aeic.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import aeic.model.NewsModel;
import aeic.services.NewsServices;

@Controller
public class News {


	
	@Autowired
	NewsServices newsServices;
	

	
	@GetMapping("news")
	public String getNews(Model model) {
		
		List<NewsModel> listNews = newsServices.getAll();
		
		model.addAttribute("getNews",listNews);
		return "news";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
     public String  showSelectedPost(Model model,@PathVariable Long id){
		
        List<NewsModel> listNews = newsServices.getAll();
		
		model.addAttribute("getNews",listNews);
		
		
       NewsModel nw = newsServices.findById(id).get();
		      model.addAttribute("nw",nw);
		           return "news";	
		    
	}
    }
