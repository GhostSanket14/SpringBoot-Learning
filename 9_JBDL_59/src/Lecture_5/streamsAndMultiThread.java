package Lecture_5;

import java.util.Arrays;

public class streamsAndMultiThread {
// .boxed() making a generic type of stream from int, float etc.
// .boxed cant be used with getAsInt() ... etc
	
	public Integer findFirstParallel(int[] arr) {
		return	Arrays.stream(arr)
		.parallel() // this will maake it runin multiple threads.
		.filter(x-> {
			System.out.println("This is the arr element "+x+" thread "+Thread.currentThread().getName());
			return x>0;
		}) 
		.findFirst()// firstFirst is circuit function. as elements after the desired element, are discarded.
		.getAsInt();
	}
	
	public Integer findFirstSequential(int[] arr) {
		
		return	Arrays.stream(arr)
		.parallel() // this will maake it runin multiple threads.
		.filter(x-> {
			System.out.println("This is the arr element "+x+" thread "+Thread.currentThread().getName());
			return x>0;
		}) 
		.findFirst()// firstFirst is circuit function. as elements after the desired element, are discarded.
		.getAsInt();
	}
	
	public Integer findAnySequential(int[] arr) {
		return	Arrays.stream(arr)
		.filter(x-> {
			System.out.println("This is the arr element "+x+" thread "+Thread.currentThread().getName());
			return x>0;
		}) 
		.findAny()
		.getAsInt();
	}

	public Integer findAnyParallel(int[] arr) {
		return	Arrays.stream(arr)
		.parallel() // this will make it runin multiple threads.
		.filter(x-> {
			System.out.println("This is the arr element "+x+" thread "+Thread.currentThread().getName());
			return x>0;
		}) 
		.findAny()
		.getAsInt();	
	}
	
	public void printParallel(int[] arr) {
		Arrays.stream(arr)
		.parallel()
		.filter((x)->x>0)
		.forEach(System.out::print);
	//	.forEachOrdered() // to print in order. but it is not as fast.
		
	}
	
	public void printSequential(int[] arr){
		Arrays.stream(arr)
		.filter((x)->x>0)
		.forEach((x)->System.out.print(x));
	}
	
	public static void main(String[] args) {
	// JBDL L5- Code 1
		streamsAndMultiThread obj=new streamsAndMultiThread();
		// To know number of available processors or CPU cores on the current machine available to JVM.
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		int arr[]= {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		// if i replaced array with set. then answer can be really anything in case of findFirst and findAny
		// as set don't have a order.
		
		System.out.println("P "+obj.findFirstParallel(arr)); // for .parallel() op is always 1 .
		System.out.println("S "+obj.findFirstSequential(arr)); // for .sequential() op is always 1 .
		// as we know streams() can automatically manage the dependent and independent tasks.
		// and some functions follow indexing of original array/data source.
		
		System.out.println();
		// example of Type of stream.
		System.out.println("P "+obj.findAnyParallel(arr)); // for .parallel() op can be anything .
		System.out.println("S "+obj.findAnySequential(arr)); // for .sequential() op is always 1 .
		
		obj.printParallel(arr); // parallel print, order is any
		System.out.println();
		obj.printSequential(arr); // sequential print, order is fix
		
	}
}