package com.sanketTest1.test1class1.HelloWorld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sanketTest1.test1class1.game.gameRunner;
import com.sanketTest1.test1class1.game.marioGame;
import com.sanketTest1.test1class1.game.pacmanGame;
import com.sanketTest1.test1class1.game.superContra;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		// STEPS 
		// Configure the things we want the spring to manage/do. via @configuration class then Launch spring context.
		
		// configuration class - HelloWorldConfigurationClass
		// bean method (inside context class) - nameFunc()
		try(var context=new AnnotationConfigApplicationContext(HelloWorldConfigurationClass.class)){ // This is how we launch a context.
		// Closing this context using, call by resources. A type of exception handling. 
		
			// Finally we are retrieving the beans managed by the spring.
		System.out.println(context.getBean("nameFunc")); // This is how we can make context access the bean methods. 
		System.out.println(context.getBean("ageFunc"));
				
		
		System.out.println(context.getBean("student")); // Person[name=Sanket, Age=21] (This is how the OP is shown)
		System.out.println(context.getBean("student2")); // Person[name=Sanket, Age=21] (This is how the OP is shown)
		System.out.println(context.getBean("CustomBean")); // Here we are using a custom bean.
		
//		System.out.println(context.getBean(Address.class)); // We can also use the function-name.class to access the bean.(Dont do this)
		System.out.println(context.getBean("student3")); // Person[name=Sanket, Age=21] (This is how the OP is shown)
		
		// THIS IS FUNCTIONAL PROGRAMMING. Do this module tomorrow.
		Arrays.stream(context.getBeanDefinitionNames()) // This is basically used to get names of all avaliable Beans.
			.forEach(System.out::println);
	}
	}
}