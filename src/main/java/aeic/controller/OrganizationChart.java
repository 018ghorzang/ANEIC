package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganizationChart {
	
	@GetMapping("/organizationchart")
	public String getAboutIssue() {
		return "organistion_chart";
	}
}
