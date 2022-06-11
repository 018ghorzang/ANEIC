package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Petroluem {
	
	@GetMapping("/petroluem")
	public String getAboutIssue() {
		return "petroluem";
	}
}
