package com.drew.tvshows.controllers;

import java.util.List;

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

import com.drew.tvshows.models.Show;
import com.drew.tvshows.models.User;
import com.drew.tvshows.services.ShowService;
import com.drew.tvshows.services.UserService;
import com.drew.tvshows.validators.UserValidator;

@Controller
public class UserController {
	
    private final UserService userService;
    private final UserValidator userValidator;
    private final ShowService showService;
    
    public UserController(UserService userService, UserValidator userValidator, 
    		ShowService showService) 
    {
        this.userService = userService;
        this.userValidator = userValidator;
        this.showService = showService;
    }
    //login page
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
	  	return "loginAndReg.jsp";
    }
    //user validation
    @RequestMapping(value="/users", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, 
    		BindingResult result, HttpSession session) 
    {
    	userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "loginAndReg.jsp";
		} 
		else {
			User validate = userService.registerUser(user);
			session.setAttribute("user_id",  validate.getId());;
			return "redirect:/shows";
		}
    }
    //login user and redirect to shows
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, 
    		Model model, HttpSession session, @ModelAttribute("user") User user) 
    {
    	boolean isAuthenticated = userService.authenticateUser(email, password);
    	if(isAuthenticated) {
    		User login = userService.findByEmail(email);
    		session.setAttribute("user_id", login.getId());
    		return "redirect:/shows";
    	} 
    	else {
    		model.addAttribute("error", "Invalid Credentials. Please try again.");
    		return "loginAndReg.jsp";
    	}
    }
    //lists all shows with title, network, and avg rating
    @RequestMapping("/shows")
    public String homePage(HttpSession session, Model model, RedirectAttributes flash) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	if(user_id == null) {
    		flash.addFlashAttribute("error", "Invalid Credentials. Please try again.");
    		return "redirect:/";
    	}
    	User list = userService.findUserById(user_id);
    	List<Show> shows = showService.findAll();
    	model.addAttribute("user", list);
    	model.addAttribute("shows", shows);
    	return "index.jsp";
    }
    //logout
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}