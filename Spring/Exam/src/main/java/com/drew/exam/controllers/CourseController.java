package com.drew.exam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.drew.exam.models.Course;
import com.drew.exam.models.User;
import com.drew.exam.services.CourseService;
import com.drew.exam.services.UserService;

@Controller
public class CourseController {

	private final CourseService courseService;
	private final UserService userService;

	public CourseController(CourseService courseService, UserService userService) {
		this.courseService = courseService;
		this.userService = userService;
	}

	@GetMapping("/courses/new")
	public String getCreateCourse(@ModelAttribute("course") Course course, BindingResult result, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User user = courseService.findUserById(userId);
		model.addAttribute("user", user);
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		return "/create.jsp";
	}

	@PostMapping(value = "/course/create")
	public String postCreateCourse(@Valid @ModelAttribute("course") Course course, BindingResult result, Model model, HttpSession session) {
		if (result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			User user = courseService.findUserById(userId);
			model.addAttribute("user", user);
			List<User> users = userService.allUsers();
			model.addAttribute("users", users);
			return "/create.jsp";
		} else {
			courseService.createCourse(course);
			return "redirect:/courses/" + course.getId();
		}
	}

	@RequestMapping("/courses")
	public String home(HttpSession session, Model model, @ModelAttribute("course") Course course) {
		Long id = (Long) session.getAttribute("userId");
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		List<Course> courses = courseService.allCourses();
		model.addAttribute("courses", courses);
		return "/readAll.jsp";
	}

	@GetMapping("/courses/{course_id}")
	public String readOneCourse(HttpSession session, Model model, @PathVariable("course_id") Long course_id) {
		Course course = courseService.findCourseById(course_id);
		model.addAttribute("course", course);
		return "/readOne.jsp";
	}
	
	@RequestMapping("/course/{course_id}/edit")
	public String getUpdateCourse(@PathVariable("course_id") Long course_id, Model model) {
		Course course = courseService.findCourseById(course_id);
		model.addAttribute("course", course);
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		return "/update.jsp";
	}

	@PostMapping(value = "/course/{id}/update")
	public String postUpdateCourse(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			List<User> users = userService.allUsers();
			model.addAttribute("users", users);
			return "/update.jsp";
		} else {
			this.courseService.updateCourse(course);
			return "redirect:/courses/" + course.getId();
		}
	}

	@PostMapping(value = "/course/{id}/adduser")
	public String addUserToCourse(Model model, @PathVariable("id") Long id, @Valid @ModelAttribute("course") Course course, BindingResult result, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		return "redirect:/courses/" + course.getId();
		
	}
	
	@RequestMapping("/course/{course_id}/delete")
	public String deleteCourse(@PathVariable("course_id") Long course_id) {
		courseService.deleteCourse(course_id);
		return "redirect:/courses";
	}
}