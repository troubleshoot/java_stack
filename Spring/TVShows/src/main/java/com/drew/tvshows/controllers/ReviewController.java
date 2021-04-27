package com.drew.tvshows.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.drew.tvshows.models.Review;
import com.drew.tvshows.models.Show;
import com.drew.tvshows.models.User;
import com.drew.tvshows.services.ReviewService;
import com.drew.tvshows.services.ShowService;
import com.drew.tvshows.services.UserService;

@Controller
public class ReviewController {
	
	private ReviewService reviewService;
	private ShowService showService;
	private UserService userService;

	public ReviewController(ReviewService reviewService, ShowService showService, UserService userService) {
		this.reviewService = reviewService;
		this.showService = showService;
		this.userService = userService;
	}
	//add review & calculate avg reviews
	@PostMapping("/shows/{id}/review")
	public String review(@Valid @ModelAttribute("review") Review review, BindingResult result, 
			Model model, @PathVariable("id") Long id, HttpSession session, RedirectAttributes flash) 
	{
		Long user_id = (Long) session.getAttribute("user_id");
		if(user_id == null) {
			flash.addFlashAttribute("error", "Insufficient permission, please log in first.");
			return String.format("redirect:/shows/%d", id);
		}
		if(result.hasErrors()) {
			model.addAttribute("show", showService.findOneById(id));
			model.addAttribute("user", userService.findUserById(user_id));
			return "viewShow.jsp";
		} 
		else {
			User user = userService.findUserById(user_id);
			Show show = showService.findOneById(id);
			List<Review> reviews = show.getReviews();
			for(Review r: reviews) {
				if(r.getUser().getId() == user.getId()) {
					flash.addFlashAttribute("error", "Only one review per show allowed.");
					return String.format("redirect:/shows/%d", id);
				}
			}
			review.setId(null);
			Review rating = reviewService.create(review);
			if(show.getAvgRating() == null) {
				show.setAvgRating(rating.getRating()/1.0);
				System.out.println(rating.getRating());
				showService.update(show);
			} 
			else {
				Double sum = 0.0;
				for(Review r: reviews) {
					sum += r.getRating();
				}
				sum += rating.getRating();
				show.setAvgRating(sum/(reviews.size()+1));
				showService.update(show);
			}
			return String.format("redirect:/shows/%d", id);
		}
	}
}