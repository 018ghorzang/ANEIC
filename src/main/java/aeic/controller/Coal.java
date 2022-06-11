package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Coal {
	
	@GetMapping("/coal")
	public String getAboutIssue() {
		return "coal";
	}
}
