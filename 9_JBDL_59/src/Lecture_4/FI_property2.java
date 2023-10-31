package Lecture_4;


public interface FI_property2{
	
	default void hi1() { // this can be made abstract later in child.
		System.out.println("Hello from FI_property2 and hi1");
	}		
}