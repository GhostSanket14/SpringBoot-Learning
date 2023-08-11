package com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.JPA.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course.course;

@Component
public class courseJPAcommandLineRunner implements CommandLineRunner {

	@Autowired
	private courseJPARepository courseRepo; // We want spring to auto wire this in. So we made it @Autowired 
	
	public void run(String... args) throws Exception {
		courseRepo.insertFunc(new course(1,"Science","Sanket"));
		courseRepo.insertFunc(new course(2,"Spiritology","Ghost"));
		courseRepo.insertFunc(new course(3,"Weapons","Capt. Price"));
		courseRepo.insertFunc(new course(4,"Games","Akash"));
			
		courseRepo.easyDeleteFunc(2);
		
		System.out.println(courseRepo.easySelectFunc(4));
}
}