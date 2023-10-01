package com.ishaquecoaching.microservices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ishaquecoaching.microservices.exception.*;
import com.ishaquecoaching.microservices.model.CourseDetails;
import com.ishaquecoaching.microservices.repository.CourseRepository;

import com.ishaquecoaching.microservices.service.CourseSequenceGeneratorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/courses")
public class CourseController {
	
	Logger log= LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseSequenceGeneratorService sequenceGeneratorService;

	@GetMapping("")
	public List<CourseDetails> getAllCourseDetails() {
		return courseRepository.findAll();
	}

	@GetMapping("/param")
	public ResponseEntity<?> getCourseDetailsById(@RequestParam(value = "id",required = false) Long courseId,@RequestParam(value = "name",required = false) String name)
			throws ResourceNotFoundException {

		if(courseId!=null) {
			log.info("requese recieved for get Course Details by id:{}",courseId);
		CourseDetails candidate = courseRepository.findById(courseId)
				.orElseThrow(() -> {
					log.error("course Not found by id:{}",courseId);
					return new ResourceNotFoundException("Employee not found for this id :: " + courseId);
				});
		return ResponseEntity.ok().body(candidate);
		}else {
			log.info("requese recieved for get Course Details by name:{}",name);
			List<CourseDetails> candidate = courseRepository.findByCourseName(name);
			if (candidate == null || candidate.size() == 0) {
				log.error("course Not found by name:{}",name);
				throw new ResourceNotFoundException("Course not found for this id :: " + name);
			}
			return ResponseEntity.ok().body(candidate);
		}
	}

	
	@PostMapping("")
	public CourseDetails createCourseDetails(@Valid @RequestBody CourseDetails course) {
		course.setId(sequenceGeneratorService.generateSequence(CourseDetails.SEQUENCE_NAME));
		return courseRepository.save(course);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CourseDetails> updateCourseDetails(@PathVariable(value = "id") Long courseId,
			@Valid @RequestBody CourseDetails employeeDetails) throws ResourceNotFoundException {
		CourseDetails courseDetails = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + courseId));

//        employee.setEmailId(employeeDetails.getEmailId());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setFirstName(employeeDetails.getFirstName());
		final CourseDetails updatedCourseDetails = courseRepository.save(courseDetails);
		return ResponseEntity.ok(updatedCourseDetails);
	}

	@DeleteMapping("/{id}")
	public Map<String, Boolean> deleteCourseDetails(@PathVariable(value = "id") Long courseId)
			throws ResourceNotFoundException {
		CourseDetails courseDetails = courseRepository.findById(courseId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + courseId));

		courseRepository.delete(courseDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
