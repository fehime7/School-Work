package Lecture2;

import java.util.Random;

public class ATM {
	
	private int balance;
	private Random rand;
	
	public ATM(int balance){
		this.balance=balance;
		rand=new Random();
	}
	
	public synchronized String drawMoney(int money){
		if(balance>=money){
			try{
				Thread.currentThread().sleep(rand.nextInt(500));
				balance=balance-money;
				return "The money you want to draw is:" +money;
			}
			catch(InterruptedException e){
				return " ";
			}
		}
		else{
		return "The money you can draw is= "+balance;
		}
		
	}
		

}
