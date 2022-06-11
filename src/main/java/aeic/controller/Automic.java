package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Automic {
	
	@GetMapping("/automic")
	public String getAboutIssue() {
		return "automic";
	}

}
