package lecture_1;

import java.util.*;

public class collectionConversion {

	public static void main(String[] args) {
		
		Integer[] myArray = { 1,2,3,4,5 };
		List<Integer> myList = Arrays.asList(myArray); // Convert Array to List 

		Integer a[]=new Integer[myList.size()];
		a = myList.toArray(a); // Convert List to wrapper type Array
		
		Object b[] = myList.toArray(a); // Convert List to Object type array.
		System.out.println(Arrays.toString(b));

	}
}