package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnergyProdution {
	
	@GetMapping("/energyprodution")
	public String getAboutIssue() {
		return "energy_prodution";
	}
}
