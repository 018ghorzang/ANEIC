package aeic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import aeic.model.VideoModel;
import aeic.services.VideoServices;

@Controller
public class Videos {
	
	@Autowired
	VideoServices videoServices;
	
	@GetMapping("/videos")
	public String getVideos(Model model) {
		
	List<VideoModel> getVideos = videoServices.getAll();
	
	model.addAttribute("videos",getVideos);
		
		return "videos";
	}
	
	
	
	
	
	
  }
