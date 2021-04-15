package com.drew.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public String code(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comment", comment);
		if(name == "" || location == "" || language == "") {
			return "redirect:/showError";
		}
		else {
			return "result.jsp";
		}
	}
	
	@RequestMapping("/showError")
	public String flashMessages(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "Invalid entries, try again..." );
		return "redirect:/";
	}
	
	@RequestMapping("/result")
	public String result(HttpSession session, Model model) {
		String name = (String) session.getAttribute("name");
		String location = (String) session.getAttribute("location");
		String language = (String) session.getAttribute("language");
		String comment = (String) session.getAttribute("comment");
		return "result.jsp";
	}

}

