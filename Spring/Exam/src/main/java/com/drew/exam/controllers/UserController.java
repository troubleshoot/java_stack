package com.drew.exam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drew.exam.models.User;
import com.drew.exam.services.UserService;

@Controller
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/")
	public String registerForm(@ModelAttribute("user") User user) {
		return "/authentication.jsp";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes attribute) {
		if (result.hasErrors()) {
			return "/authentication.jsp";
		} else if (userService.checkUser(user.getEmail())) {
			attribute.addFlashAttribute("registrationError", "User already exists");
			return "redirect:/";
		} else if (!user.getPassword().equals(user.getPasswordConfirmation())) {
			attribute.addFlashAttribute("registrationError", "Passwords do not match");
			return "redirect:/";
		} else {
			User new_user = userService.registerUser(user);
			session.setAttribute("loggedIn", user);
			session.setAttribute("userId", new_user.getId());
			return "redirect:/courses";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session, RedirectAttributes attribute) {
		if (email.length() < 1) {
			attribute.addFlashAttribute("loginError", "Must enter an email");
			return "redirect:/";
		} else if (password.length() < 1) {
			attribute.addFlashAttribute("loginError", "Must enter a password");
			return "redirect:/";
		} else if (userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			if (user == null) {
				attribute.addFlashAttribute("loginError", "User does not exist");
			} else {
				session.setAttribute("userId", user.getId());
				session.setAttribute("loggedIn", true);
				return "redirect:/courses";
			}
		} else {
			attribute.addFlashAttribute("loginError", "Invalid Password");
		}
		return "redirect:/";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}