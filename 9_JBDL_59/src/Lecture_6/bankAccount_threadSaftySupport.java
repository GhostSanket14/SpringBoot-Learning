package Lecture_6;

public class bankAccount_threadSaftySupport {

	private int balance;
	private int id;
	
	public bankAccount_threadSaftySupport(int balance, int id) {
		this.balance = balance;
		this.id = id;
	}
	
	public int addBalance(int money) {
		this.balance+=money;
		return this.balance;
	}
	
	public int withdrawBalance(int money) {
		this.balance-=money;
		return this.balance;
	}

	public int getBalance() {
		return this.balance;
	}
	
}