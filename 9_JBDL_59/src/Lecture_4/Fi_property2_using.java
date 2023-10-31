package Lecture_4;

public class Fi_property2_using{

	public static void main(String[] args) {
		
		obj.hi1(); // OP- lambda, (if there is hi1(); in FI-property2_support )
		obj.hi1(); // OP- FI_property2, (if there is NO hi1(); in FI-property2_support As now it will look into parent )
		
	}
	
	static FI_property2_support obj= ()-> System.out.println("This lambda overriden parent");

	
}