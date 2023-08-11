package com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.JPA.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course.course;
import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.springDataJPA.springDataJPA_Repository;

@Component
public class courseSpringDataJPAcommandLineRunner implements CommandLineRunner { // CommandLineRunner is necessary. Interface used to indicate that a bean should run when it is contained within a SpringApplication

	@Autowired
	private springDataJPA_Repository courseRepo; // We want spring to auto wire this in. So we made it @Autowired 
	
	public void run(String... args) throws Exception {
		courseRepo.save(new course(1,"Science","Sanket"));
		courseRepo.save(new course(2,"Gods Grace","Ghost"));
		courseRepo.save(new course(3,"Weapons","Capt. Price"));
		courseRepo.save(new course(4,"Games","Akash"));
			
		courseRepo.deleteById(3);
		
		System.out.println(courseRepo.findById(4));
		
		System.out.println("My method 1 "+courseRepo.findByCourseAuthor("Sanket"));
		// this method i made will search a row, based on author of course.
		
		System.out.println("My method 2 "+courseRepo.findByName("Games")); // OP- My method 2 [course [id=4, name=Games, courseAuthor=Akash]]
		System.out.println("My method 2 "+courseRepo.findByName("ABC")); // OP (if dont exist)- My method 2 []

		
		
		//	courseRepo. <- you can see lot of good stuff here :)
	}
}