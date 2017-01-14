package Lecture;

public class ATM {
	private int balance;
	
	public ATM(int balance){
		this.balance=balance;
	}
	
	public void drawMoney(int money){
		if(balance>=money){
			try{
				Thread.currentThread().sleep(500);
				balance=balance-money;
				System.out.println(money);
			}
			catch(InterruptedException e){
				System.out.println("Ploblem ");
			}
		}
		else{
		System.out.println("The money you can draw is= "+balance);
		}
	}
		

}
