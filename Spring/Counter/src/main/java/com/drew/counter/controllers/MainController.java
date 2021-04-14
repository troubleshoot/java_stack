package com.drew.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("")
	String index(HttpSession session) {
		if(session.getAttribute("counter") == null)
			session.setAttribute("counter", 0);
		else {
			Integer sessionCounter = (Integer) session.getAttribute("counter");
			sessionCounter += 1;
			session.setAttribute("counter", sessionCounter);
		}
		return "index.jsp";
	}

	@GetMapping("/counter")
	String counter(Model model, HttpSession session) {
		Integer sessionCounter = (Integer) session.getAttribute("counter");
		sessionCounter += 1;
		session.setAttribute("counter", sessionCounter);
		Integer counter = (Integer) session.getAttribute("counter");
		model.addAttribute("visits", counter);
		return "counter.jsp";
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
