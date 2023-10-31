package Lecture_6;

import java.math.BigInteger;
import java.util.Arrays;

public class factorialViaMT_simpleVariation{
	
	// as parallel() provide with threads and multithreading. we don't have to make our own.
	// Also this code is easy to understand.
	
	public static void main(String args[]) {
		
		// int arr[]= {10000,20000,30000,40000,50000,60000,70000,80000,90000,100000,200000};
		int arr[]= {12,3,4,5,6,7,8,9};
		
		Arrays.stream(arr)
		.parallel()
		.mapToObj(factorialViaMT_simpleVariation::calFactorialMT) // this returns a object stream with our values.
		.forEach(System.out::println);
	}
	
	public static BigInteger calFactorialMT(int N){

		BigInteger Bi=BigInteger.ONE;
		for(int i=2; i<=N; i++) { // we will calculate factorial from 2 to MyElement.
			Bi=Bi.multiply(BigInteger.valueOf(i));
		}
		System.out.println("On thread: "+Thread.currentThread().getName());
		return Bi;
	}
	
}