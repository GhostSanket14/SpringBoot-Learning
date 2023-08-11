package com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.JDBC.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course.course;
import com.BasicsOfSpringBootJPAHybernate.learnJPAHybernate.course.courseDelete;

@Component
public class courseJDBCcommandLineRunner implements CommandLineRunner {

	@Autowired
	private courseJDBCRepository courseRepo; // We want spring to auto wire this in. So we made it @Autowired 
	
	public void run(String... args) throws Exception {
		courseRepo.insertFunc(new course(1,"Psychology","Sanket"));
		courseRepo.insertFunc(new course(2,"Spiritology","Ghost"));
		courseRepo.insertFunc(new course(3,"Weapons","Capt. Price"));
		courseRepo.insertFunc(new course(4,"Games","Akash"));
		
		courseRepo.deleteFunc(new courseDelete(1)); // here we are creating a class to have more flexibility.
		
		courseRepo.easyDeleteFunc(2); // This is basically a pass by value.
		
		System.out.println(courseRepo.easySelectFunc(4));// OP-course [id=4, name=Games, courseAuthor=Akash]

}
}