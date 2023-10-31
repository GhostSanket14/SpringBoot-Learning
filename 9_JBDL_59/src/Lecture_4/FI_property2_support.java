package Lecture_4;

@FunctionalInterface
public interface FI_property2_support extends FI_property2{
	
	void hi2(); // in this case we have made it abstract. As it is ours and not form Object class.
	
	int hashCode(); // as u can see. This function even though have implementation in object.java 
		// and we made it abstract here, it is still not abstract. Since it is from Object. So keep in mind this.
}

// Ie. we can have overriding abstract method, but it must be from object.java
// and we can't make our own overriding abstract method.