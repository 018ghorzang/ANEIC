package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ElectricityGeneration {
	
	@GetMapping("/electricitygeneration")
	public String getAboutIssue() {
		return "electricity_generation";
	}
}
