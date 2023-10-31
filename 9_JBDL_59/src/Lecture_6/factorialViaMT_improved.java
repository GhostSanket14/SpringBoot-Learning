package Lecture_6;

import java.math.BigInteger;

public class factorialViaMT_improved{
	
	// In this we will also learn how to make multiple threads via loop.

	public static void main(String args[]) throws InterruptedException {
		
		// int arr[]= {10000,20000,30000,40000,50000,60000,70000,80000,90000,100000,200000};
		int arr[]= {12,3,4,5,6,7,8,9};
		
		myFactClass obj[]=new myFactClass[arr.length];
		
		for(int i=0; i<arr.length; i++) { // NOTE- if we add join() then it will become sequential code
			obj[i]=new myFactClass(arr[i]); 
			obj[i].start();
		}		
		// you may confuse it, but this is still multithreading. look at diagram in book.
		for(int i=0; i<arr.length; i++) { // we do know join joins the thread. But here how it works is.
			obj[i].join();	// in above loop we have already started all the threads. So now it cant make 
			System.out.println("R "+obj[i].result);// next thread wait before previous execute.
		} // so this join() will now only wait for them to finish executing one by one.
		// every thread have some internal storage, thats why even if thread dies we can still use its data.
		// that why even if a thread from first loop starts and dies the second loops join() can still use it.
				
		// Normally- join() is used for adding sequencing between multiple threads, one thread starts execution after first thread execution finished.		
	}
	
	// there is no harm in waiting for thread. but if we use join() while creating a thread, then it will be
	// sequential program.
	
	
	public static class myFactClass extends Thread{
		int MyElement;
		private BigInteger result; // as run() also cant return anything we can use simple var to pass answers.
		
		public myFactClass(int passedElement) {
			this.MyElement=passedElement;
		}
		
		@Override
		public void run() {
			calFactorialMT(MyElement);		
		}
		
		public void calFactorialMT(int N){
			long start=System.currentTimeMillis(); // getting epoch time.
			BigInteger Bi=BigInteger.ONE;
			
			for(int i=2; i<=N; i++) { // we will calculate factorial from 2 to MyElement.
				Bi=Bi.multiply(BigInteger.valueOf(i));
			}
			long end=System.currentTimeMillis(); // getting epoch time.
			result=Bi;
			System.out.println("time taken : "+(end-start)+" On thread: "+Thread.currentThread().getName());
		}
		
	}
	
}