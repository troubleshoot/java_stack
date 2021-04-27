package com.drew.tvshows.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.drew.tvshows.models.Show;
import com.drew.tvshows.repositories.ShowRepository;

@Service
public class ShowService {
	
	private ShowRepository showRepository;

	public ShowService(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}
	
	public Show create(Show show) {
		return showRepository.save(show);
	}
	
	public Show update(Show show) {
		return showRepository.save(show);
	}
	
	public List<Show> findAll() {
		return showRepository.findAll();
	}
	
	public Show findOneById(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		
		if(optionalShow.isPresent()) {
			return optionalShow.get();
		} 
		else {
			return null;
		}
	}
	
	public void delete(Long id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if(optionalShow.isPresent()) {
			showRepository.deleteById(id);
		} 
		else {
			System.out.println("Show does not exist");
		}
	}
}