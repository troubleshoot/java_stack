package com.drew.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.drew.lookify.models.Song;
import com.drew.lookify.repositories.LookifyRepository;

@Service
public class LookifyService {
	private final LookifyRepository lookifyRepository;

	public LookifyService(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }

	public List<Song> allSongs() {
		return lookifyRepository.findAll();
	}
	
	public Song createSong(Song createSong) {
		return lookifyRepository.save(createSong);
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = lookifyRepository.findById(id);
		if (optionalSong.isPresent()) 
			return optionalSong.get();
		else
			return null;
	}

	public void deleteSong(Long id) {
		Song deleteSong = this.findSong(id);
		lookifyRepository.delete(deleteSong);
	}
	
	public List<Song> findArtistSongs(String search) {
		return lookifyRepository.findByArtistContaining(search);
	}
}
