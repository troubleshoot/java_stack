package com.drew.strings.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	// LISTEN FOR URLS AND SEND BACK RESPONSES
	@RequestMapping("")
	public String index() {
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String random() {
		return "Spring Boot is great! So easy to just respond with strings.";
	}
}
