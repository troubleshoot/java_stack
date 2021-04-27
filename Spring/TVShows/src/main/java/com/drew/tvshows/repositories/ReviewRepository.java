package com.drew.tvshows.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.drew.tvshows.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

}