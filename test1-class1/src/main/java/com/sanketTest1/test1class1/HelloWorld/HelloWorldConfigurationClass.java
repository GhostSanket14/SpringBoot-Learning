package com.sanketTest1.test1class1.HelloWorld;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

record Person(String name, int Age, Address addr) {  }  // This is how we create a record. (Benefit being we don't have to make getter or setter.) 
// Basically treat it as a class that already has, getter(), setter() and constructor(). We mainly use it to make its type of objects.
record Address(String City, int pinCode) {   }

@Configuration // This indicates that this class is a spring configuration class.
public class HelloWorldConfigurationClass {
	
	@Bean // This is used to indicate a bean method.
	public String nameFunc() {
		return "Sanket";
	}	
	
	@Bean
	public int ageFunc() {
		return 21;
	}
	
	@Bean (name="CustomBean") // If we have multiple matching beans. We can either use, @primary or @Qualifier.
	@Primary					// expected single matching bean but found 2: CustomBean,baseAddress2 
	public Address baseAddress(){
		return new Address("Gadhinglaj",416502);
	}
	@Bean
	public Address baseAddress2(){
		return new Address("Kolhapur",516502);
	}
	
	@Bean
	public Person student() {
//		var studPer=new Person("Sanket",21);
//		return studPer;
		return new Person("Sanket",21, baseAddress());
	}
	// We can also link 2 Beans. Just simply call the methods.
	@Bean
	public Person student2() { // Parameter is a alternative way.
		return new Person(nameFunc(),ageFunc(), new Address("Inchanal",416503)); // This is how we can link/inject/Auto wire	 the Beans. This is how we create new function values.
	}
	
	// Instead of calling the methods directly we can use parameters as well.
	@Bean
	public Person student3(String name, int Age, Address address) { // Values will be put below. These are names of existing bean-types. (here the address will cause issue, so i have used @primary above)
		return new Person(name,Age, address); // Above is basically injection/ Auto-wiring. IMP- Address address (Here the 'Address' is what used to define a bean passed, 'address' is just a name,  we can put anythig we want). This is actually called wiring.
		//	[NOTE - If a Bean has custom name, use that instead of function name].
	}
}