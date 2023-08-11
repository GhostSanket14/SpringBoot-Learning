package com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.JPA.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course.course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class courseJPARepository {
	
//	@Autowired <- here instead of using this. we use below, to be more specific.
// Persistence context keeps track of any changes made into a managed entity.
	
	@PersistenceContext // This help to inject EntityManager, 
	private EntityManager entManObj; // Entity Manager manages the entities.
	
	
	// Below is proof that entity manager handels the code. We No worry.
	public void insertFunc(course CourseObj) {
		entManObj.merge(CourseObj);
	}

	public course easySelectFunc(long idPass) {
		return entManObj.find(course.class, idPass);
	}
	
	public void easyDeleteFunc(long idPass) {
		course courseObj=entManObj.find(course.class, idPass);
		entManObj.remove(courseObj);; 
	}
} // As you can see a lot of code is reduced.