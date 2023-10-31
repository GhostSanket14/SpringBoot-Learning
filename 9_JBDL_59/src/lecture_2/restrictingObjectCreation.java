package lecture_2;

public class restrictingObjectCreation { // This is concept of singleton class.

	// class having single object is singleton class.
	
	private static restrictingObjectCreation object=null; 
	
	// Keep in mind, if i made more construcor, then once again it will become normal class. And not singleton class. 
	
	private restrictingObjectCreation() { // we can restrict creation of object using private constructor. instead of public.
		System.out.println("Object created is: "+this);
	}	// 1. now only this class can make object of this class.
	

	// 2. suppose we want this class to make 1 object only as well.
	public static restrictingObjectCreation checkObjectCreation() {
		if(object==null) {
			object= new restrictingObjectCreation(); // 
		}
		
		return object; 
	}
	
	public static void main(String[] args) {

		System.out.println("Objects in same class");
		restrictingObjectCreation obj1=restrictingObjectCreation.checkObjectCreation();
		restrictingObjectCreation obj2=restrictingObjectCreation.checkObjectCreation(); // only 1 object will be made.
		System.out.println(obj1+"\n"+obj2);
		System.out.println();
		restrictingObjectCreation obj3=new restrictingObjectCreation();
		restrictingObjectCreation obj4=new restrictingObjectCreation();
		System.out.println(obj3+"\n"+obj4); // in this case, we are accessing class directly, so we can make many objects. 
		
	}
}