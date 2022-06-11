package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Gas {
	
	@GetMapping("/gas")
	public String getAboutIssue() {
		return "gas";
	}
}
