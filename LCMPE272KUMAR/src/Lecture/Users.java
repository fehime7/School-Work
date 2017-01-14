package Lecture;

import java.util.concurrent.locks.ReentrantLock;

public class Users extends Thread {
	private ATM atm;
	private int money;
	public ReentrantLock lock;
	
	public Users (ATM amt, int money, ReentrantLock lock){
		this.atm=atm;
		this.money=money;
		this.lock=lock;
	}
	
	public void run(){
		lock.lock();
		   atm.drawMoney(money);
		lock.unlock();   
	}

}
