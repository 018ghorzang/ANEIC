package aeic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataChart {
	
	@GetMapping("/datachart")
	public String getAboutIssue() {
		return "data_chart";
	}
}
