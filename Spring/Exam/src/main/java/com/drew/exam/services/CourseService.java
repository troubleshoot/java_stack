package com.drew.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.drew.exam.models.Course;
import com.drew.exam.models.User;
import com.drew.exam.repositories.CourseRepository;
import com.drew.exam.repositories.UserRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;
	private final UserRepository userRepository;

	public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}

	public Course updateCourse(Course course) {
		return this.courseRepository.save(course);

	}

	public void deleteCourse(Long course_id) {
		courseRepository.deleteById(course_id);
	}

	public List<Course> allCourses(){
		return courseRepository.findAll();
	}

	public Course findCourseById(Long course_id) {
		return courseRepository.findCourseById(course_id);
	}

	public User findUserById(Long user_id) {
		Optional<User> u = userRepository.findById(user_id);
		if (u.isPresent()) {
			return u.get();
		} else {
			return null;
		}
	}
	public User addUser(Long user_id, Course course) {
		course.setUsers(getUsers() + user_id); .getUsers()userRepository.findById(user_id));
		
	}
}