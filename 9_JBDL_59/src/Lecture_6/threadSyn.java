package Lecture_6;

public class threadSyn{

// Complete these types of examples from YT channel.
// no need finish this one specifically, but finish these type of examples. 
	
	public static void main(String args[]) throws InterruptedException {
		
		bankAccount_threadSaftySupport acc1=new bankAccount_threadSaftySupport(1000,1);
//		System.out.println(acc1.withdrawBalance(100));
//		System.out.println(acc1.addBalance(200));
		
	// if i run this code in loop. it will eventually give wrong OP. as 2 writes are happening simultaneously.
		myThread t1=new myThread(acc1, true, 1000);
		myThread t2=new myThread(acc1, false, 500);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("After t1 and t2 "+acc1.getBalance());
		
	}
	
	private static class myThread extends Thread{
		bankAccount_threadSaftySupport bankAccount;
		private boolean isDeposit;
		private int amount;
		
		
		
		public myThread(bankAccount_threadSaftySupport bankAccount, boolean isDeposit, int amount) {
			super();
			this.bankAccount = bankAccount;
			this.isDeposit = isDeposit;
			this.amount = amount;
		}



		@Override
		public void run() { 
			if(isDeposit) {
				this.bankAccount.addBalance(this.amount);
			}else {
				this.bankAccount.withdrawBalance(this.amount);
			}
		}
		
	}
}