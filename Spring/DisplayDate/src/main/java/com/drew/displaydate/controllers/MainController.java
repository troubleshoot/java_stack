package com.drew.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/date")
	public String date(Model model) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE,' the ' d ' of ' MMMM, yyyy");
		String formattedDate = dateFormatter.format(new Date());
		model.addAttribute("date", formattedDate);
		return "date.jsp";
	}

	@GetMapping("/time")
	public String time(Model model) {
		SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
		String formattedTime = timeFormatter.format(new Date());
		model.addAttribute("time", formattedTime);
		return "time.jsp";
	}
}
