package Lecture_4;

@FunctionalInterface
public interface FI_proerty1{
	
	void hi(); // this is abstract and it is non-overriding.
	
	default void yo() { // we can have as many static and default as we like.
		
	}
	static int yoy() {
		return 0;
	}
	
}