package com.drew.hellohuman.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@RequestMapping("/")
	public String hello() {
		return "Hello Human! Welcome to SpringBoot!";
	}
	@RequestMapping(value = "/{name}")
	public String name(@PathVariable("name") String name) {
		return "Hello " + name + "! Welcome to SpringBoot";
	}

}