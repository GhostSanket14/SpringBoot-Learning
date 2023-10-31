package lecture_2;

public class restrictingObjectCreation_testing {

	
	public static void main(String[] args) {

//		restrictingObjectCreation obj=new restrictingObjectCreation(); // not allowed. Due to private.

		System.err.println("Objects in testing class"); // err to make red color OP
		restrictingObjectCreation obj1=restrictingObjectCreation.checkObjectCreation(); // as this method is static we can call it with class name. 
		restrictingObjectCreation obj2=restrictingObjectCreation.checkObjectCreation();					// no need to create object.
		
		System.out.println(obj1);
		System.out.print(obj2);
		
	}
} // only 1 object will be made.