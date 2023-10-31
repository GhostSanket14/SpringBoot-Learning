package Lecture_5;

public class jbdl_thread1 {

	private static class myThread extends Thread{ 
		@Override
		public void run() { // this is where we write our code. 
			System.out.println("This is my thread "+Thread.currentThread().getName());
			long add=0;
			for(int i=0; i<100000; i++) {
				add+=i;
			}
			System.out.println("ADD thread my "+add);
		}
	}
	
	public static void main(String[] args) {
	
		System.out.println("Top of my thread in main - "+Thread.currentThread().getName()+" \n");
		
		myThread thr=new myThread(); // I created a thread object of my class.
		myThread thr1=new myThread(); // I created a thread object of my class.
		thr.setPriority(10); // to set priority.
		thr1.setPriority(7); // to set priority.
		thr.start(); // without this the thread wont start.
		thr1.start(); // without this the thread wont start.
		
		long add=0;
		for(int i=0; i<100000; i++) {
			add+=i;
		}
		System.out.println("ADD thread main "+add+" \n");

		System.out.println("Bottom of my thread in main - "+Thread.currentThread().getName()+" \n");
	}
}