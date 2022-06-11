package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Biomass {
	

	@GetMapping("/biomass")
	public String getAboutIssue() {
		return "biomass";
	}
}
