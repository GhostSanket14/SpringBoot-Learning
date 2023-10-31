package Lecture_6;

import java.math.BigInteger;

public class factorialViaMT{
	
	// In this we will also learn how to make multiple threads via loop.

	public static void main(String args[]) {
		
		int arr[]= {10000,20000,30000,40000,50000,60000,70000,80000,90000,100000,200000};
		//int arr[]= {12,3,4,5,6,7,8,9};
		
		myFactClass obj[]=new myFactClass[arr.length]; // array of type class.
		
		for(int i=0; i<arr.length; i++) {
			obj[i]=new myFactClass(arr[i]); // as we cant pass para to run. we use a constructor.
			obj[i].start(); // this line is our thread, above and below are main thread.
			System.out.println("R"+obj[i].result); // This way we can also access values. 
			// but above we wont get OP, as we are basically printing without knowing if thread has done execution or not.
		}		
	}
	
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