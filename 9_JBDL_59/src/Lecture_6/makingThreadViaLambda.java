package Lecture_6;

import java.util.concurrent.Callable;

public class makingThreadViaLambda {

	public static void main(String[] args) {
	
		// as this is a functional interface we can make thread using this and inner class.
		// This feature was introduced in java 8
		System.out.println("This thread is : "+Thread.currentThread().getName());
		Runnable thr=()->{
			System.out.println("This thread is : "+Thread.currentThread().getName());
		};
		
		Thread t1=new Thread(thr);
		t1.start();
		Thread t2=new Thread(thr);
		t2.start();

	}
} // if we want our thread to return something we can use callable.