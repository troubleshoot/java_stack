package com.drew.tvshows.services;

import org.springframework.stereotype.Service;

import com.drew.tvshows.models.Review;
import com.drew.tvshows.repositories.ReviewRepository;

@Service
public class ReviewService {
	
	private ReviewRepository reviewRepository;
	
	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	public Review create(Review review) {
		return reviewRepository.save(review);
	}
}