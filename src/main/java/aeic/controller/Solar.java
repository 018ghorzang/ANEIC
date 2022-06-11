package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Solar {
	
	@GetMapping("/solar")
	public String getAboutIssue() {
		return "solar";
	}
}
