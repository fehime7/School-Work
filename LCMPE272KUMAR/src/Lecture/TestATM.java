package Lecture;

import java.util.concurrent.locks.ReentrantLock;

public class TestATM {
	public static void main(String[] args) {
		
		ATM atm = new ATM(1000);
		ReentrantLock lock=new ReentrantLock();
		Users u1=new Users(atm, 500, lock);
		Users u2=new Users(atm, 400, lock);
		
		u1.start();
		u2.start();
	}

}
