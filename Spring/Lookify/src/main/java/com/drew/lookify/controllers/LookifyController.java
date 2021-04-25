package com.drew.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.drew.lookify.models.Song;
import com.drew.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;

	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}

	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/newSong.jsp";
	}

	@RequestMapping(value = "/createSong", method = RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song createSong, BindingResult result) {
		if (result.hasErrors()) {
			return "/newSong.jsp";
		} else {
			lookifyService.createSong(createSong);
			return "redirect:/dashboard";
		}
	}

	@RequestMapping("/")
	public String dashboard() {
		return "/welcome.jsp";
	}

	@RequestMapping("/dashboard")
	public String index(Model model) {
		List<Song> songs = lookifyService.allSongs();
		model.addAttribute("songs", songs);
		return "/index.jsp";
	}

	@GetMapping("/songs/{song_id}")
	public String show(Model model, @PathVariable("song_id") String id) {
		model.addAttribute("song", lookifyService.findSong((long) Integer.parseInt(id)));
		return "/showSong.jsp";
	}

	@RequestMapping(value = "/songs/{song_id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("song_id") Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("search") String search, Model model) {
		List<Song> songs = lookifyService.findArtistSongs(search);
		model.addAttribute("song", songs);
		return "redirect:/search/" + search;
	}

	@RequestMapping("/search/{search}")
	public String searchSong(@PathVariable("search") String search, Model model) {
		List<Song> songs = lookifyService.findArtistSongs(search);
		model.addAttribute("songs", songs);
		return "/artistSearchResults.jsp";
	}
}

