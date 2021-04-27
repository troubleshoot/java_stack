package com.drew.exam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.drew.exam.models.Course;



public interface CourseRepository extends CrudRepository<Course, Long>{

	List<Course> findAll();

	Course findCourseById(Long course_id);
}