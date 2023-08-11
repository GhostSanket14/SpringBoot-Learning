package com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.springDataJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course.course;

public interface springDataJPA_Repository extends JpaRepository< course, Integer > {
	// Basically this JpaRepository means, we no longer have to make entity manager.
	// spring-data-jpa does and manages it for us 

	List<course> findByCourseAuthor(String author); // This is method we made.
					// Remember we have to follow a naming rule.
					// Name if datatype must be there, u can use camel case.
	
	List<course> findByName(String name); // Remember here we are talking about course name.
}