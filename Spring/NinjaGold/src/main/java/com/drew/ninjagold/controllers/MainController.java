package com.drew.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	String pattern = "'('MMMMM dd yyyy hh:mm a')'";
	SimpleDateFormat  timeStamp = new SimpleDateFormat(pattern);
	String time = timeStamp.format(new Date());
	
	@RequestMapping("/")
	String main(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", "No activities "+ time + ",     ");
		}
		Integer gold = (Integer) session.getAttribute("gold");
		String activites = (String) session.getAttribute("activites");
		return "main.jsp";
	}
	
	@RequestMapping(path="/gold", method=RequestMethod.POST)
	public String gold(HttpSession session, @RequestParam String location) {
		session.setAttribute("location", location);
		Integer gold = (Integer) session.getAttribute("gold");
		String activities = (String) session.getAttribute("activities");
		if(location.equals("farm")) {
			Integer earnedGold = (int)(Math.random() * 11) + 10;
			gold += earnedGold;
			session.setAttribute("gold", gold);
			session.setAttribute("activities", "You entered a farm and earned " + earnedGold + " gold. " + time + ",     " + activities);
			return "redirect:/";
		}
		if(location.equals("cave")) {
			Integer earnedGold = (int)(Math.random() * 6) + 5;
			gold += earnedGold;
			session.setAttribute("gold", gold);
			session.setAttribute("activities", "You entered a cave and earned " + earnedGold + " gold. " + time + ",         " + activities);
			return "redirect:/";
		}
		if(location.equals("house")) {
			Integer earnedGold = (int)(Math.random() * 4) + 2;
			gold += earnedGold;
			session.setAttribute("gold", gold);
			session.setAttribute("activities", "You entered a house and earned " + earnedGold + " gold. " + time + ",     " + activities);
			return "redirect:/";
		}
		if(location.equals("casino")) {
			Integer earnedGold = (int)(Math.random() * 100) - 50;
			gold += earnedGold;
			session.setAttribute("gold", gold);
			session.setAttribute("activities", "You entered a casino and earned " + earnedGold + " gold. " + time + ",     " + activities);
			return "redirect:/";
		}
		return "redirect:/error";
		
	}
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
