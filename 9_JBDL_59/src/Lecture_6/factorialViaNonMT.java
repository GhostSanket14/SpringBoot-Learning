package Lecture_6;
import java.math.BigInteger;
public class factorialViaNonMT {
	
// Non- multithreading code. To see how much both type of codes take.
	public static BigInteger calFactorial(int N){
		long start=System.currentTimeMillis(); // getting epoch time.
		BigInteger Bi=BigInteger.ONE;
		
		for(int i=1; i<=N; i++) {
			Bi=Bi.multiply(BigInteger.valueOf(i));
		}
		long end=System.currentTimeMillis(); // getting epoch time.
		System.out.println("time taken : "+(end-start)+" On thread: "+Thread.currentThread().getName());
		
		return Bi;
	}
	public static void main(String[] args) {
		factorialViaNonMT obj=new factorialViaNonMT();
		//int arr[]= {10000,20000,30000,40000,50000,60000,70000,80000,90000,100000,200000};
		int arr[]= {12,3,4,5,6,7,8,9};
		
		System.out.println("NON-MT code");
		for(Integer i: arr) {
			calFactorial(i); // non-MT
		}
	}
}