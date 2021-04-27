package com.drew.tvshows.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drew.tvshows.models.Review;
import com.drew.tvshows.models.Show;
import com.drew.tvshows.models.User;
import com.drew.tvshows.services.ShowService;
import com.drew.tvshows.services.UserService;

@Controller
public class ShowController {
	
	private ShowService showService;
	private UserService userService;

	public ShowController(ShowService showService, UserService userService) {
		this.showService = showService;
		this.userService = userService;
	}
	//page to create new show
	@RequestMapping("/shows/new")
	public String newShow(
			Model model, @ModelAttribute("show") Show show, 
			HttpSession session, RedirectAttributes flash) 
	{
		Long user_id = (Long) session.getAttribute("user_id");
		if(user_id == null) {
			flash.addFlashAttribute("error", "Insufficient permission, please log in first.");
			return "redirect:/";
		}
		User user = userService.findUserById(user_id);
		model.addAttribute("user", user);
		return "newShow.jsp";
	}
	//post to create new show then routes back to home
	@PostMapping("/shows")
	public String createShow(
			@Valid @ModelAttribute("show") Show show, BindingResult result, 
			HttpSession session, RedirectAttributes flash) 
	{
		Long user_id = (Long) session.getAttribute("user_id");
		if(user_id == null) {
			flash.addFlashAttribute("error", "Insufficient permission, please log in first.");
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "newShow.jsp";
		} 
		else {
			Show view = showService.create(show);
			Long newShowId = view.getId();
			return String.format("redirect:/shows/%d", newShowId);
		}
	}
	//shows specific show
	@RequestMapping("/shows/{id}")
	public String showShow(
			Model model, @PathVariable("id") Long id, HttpSession session, 
			RedirectAttributes flash, @Valid @ModelAttribute("review") Review review, BindingResult result) 
	{
		Long user_id = (Long) session.getAttribute("user_id");
		if(user_id == null) {
			flash.addFlashAttribute("error", "Insufficient permission, please log in first.");
			return "redirect:/";
		}
		model.addAttribute("show", showService.findOneById(id));
		User user = userService.findUserById(user_id);
		model.addAttribute("user", user);
		return "viewShow.jsp";
	}
	//page to edit show
	@RequestMapping("/shows/{id}/edit")
	public String editShow(
			Model model, @PathVariable("id") Long id, HttpSession session, 
			RedirectAttributes flash) 
	{
		Show edit = showService.findOneById(id);
		Long user_id = (Long) session.getAttribute("user_id");
		if(user_id == null) {
			flash.addFlashAttribute("error", "Insufficient permission, please log in first.");
			return "redirect:/";
		} 
		model.addAttribute("show", edit);
		return "editShow.jsp";
	}
	//page to update said show
	@RequestMapping("/shows/{id}/update")
	public String updateShow(@Valid @ModelAttribute("show") Show show, 
			BindingResult result, @PathVariable("id") Long id, 
			HttpSession session, RedirectAttributes flash) 
	{
		Long user_id = (Long) session.getAttribute("user_id");
		if(user_id == null) {
			flash.addFlashAttribute("error", "Insufficient permission, please log in first.");
			return "redirect:/";
		} 
		if(result.hasErrors())
			return "editShow.jsp";
		else {
			showService.update(show);
			return String.format("redirect:/shows/%d", id);
		}
	}
	//delete show
    @RequestMapping(value="/shows/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id, HttpSession session, 
    		RedirectAttributes flash) 
    {
    	Long user_id = (Long) session.getAttribute("user_id");
    	if(user_id == null) {
    		flash.addFlashAttribute("error", "Insufficient permission, please log in first.");
    		return "redirect:/";
    	} 
    	showService.delete(id);
    	return "redirect:/shows";
    }
	
	
}