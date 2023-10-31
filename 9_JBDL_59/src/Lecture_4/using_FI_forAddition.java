package Lecture_4;

public class using_FI_forAddition {

	public static void main(String[] args) {
	
		
		making_FI_forAddition fiAddObj=(a,b)-> a+b; // This way we map a lambda to our FI. as it has only 1 Abstract method.
		int a=10, b=4;
		
		System.out.println("Ans is "+fiAddObj.add(a, b));

	}
}