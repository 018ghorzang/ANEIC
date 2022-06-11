package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class read {
	
	
	@GetMapping("/aboutIssue")
	public String getAboutIssue() {
		return "read_more";
	}

}
