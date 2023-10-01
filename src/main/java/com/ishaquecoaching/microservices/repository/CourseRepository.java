package com.ishaquecoaching.microservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;
import com.ishaquecoaching.microservices.model.CourseDetails;
import java.util.List;

@Repository
public interface CourseRepository
		extends MongoRepository<CourseDetails, Long>{

	public List<CourseDetails> findByCourseName(String courseName);
}
