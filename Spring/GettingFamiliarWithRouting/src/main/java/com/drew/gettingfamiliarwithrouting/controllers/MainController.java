package com.drew.gettingfamiliarwithrouting.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	// LISTEN FOR URLS AND SEND BACK RESPONSES
	@RequestMapping("")
	public String index() {
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping("/coding")
	public String coding() {
		return "Hello Coding Dojo!";
	}
	
	@RequestMapping("/coding/python")
	public String python() {
		return "Python/Django was awesome!";
	}
	
	@RequestMapping("/coding/java")
	public String java() {
		return "Java/Spring is better!";
	}
	
	@RequestMapping(value="/{input}",method=RequestMethod.GET)
	public String hello(@PathVariable("input") String input){
    	if (input.equals("dojo"))
    		return "The dojo is awesome";
    	else if (input.equals("burbank-dojo"))
    		return "Burbank dojo is in Southern California";
    	else if (input.equals("san-jose"))
    		return "SJ dojo is the headquarters";
		return input;
	}
 }

