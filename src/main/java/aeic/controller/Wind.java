package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Wind {
	
	@GetMapping("/wind")
	public String getAboutIssue() {
		return "wind";
	}
}
