package Lecture_4;

public class WaysToMakeFI_object {

	public static void main(String[] args) {
	
		// There are 3 ways to make object of functional interface.
		
		// WAY 1, we make anonymous inner class.
		making_FI_forAddition obj1=new making_FI_forAddition() {
			
			public int add(int x, int y) {
				return 0;
			}
			
		};
		obj1.add(10, 4);
		
		// WAY 2, this is how we normally do. (offers reusability)
		making_FI_forAddition obj2=new WaysToMakeObjectOfFI_class();
		obj2.add(10, 4);
		
		// WAY 3, is lambda. Easy and fast. we only have to worry about parameters, body and return of lambda.

	}
}