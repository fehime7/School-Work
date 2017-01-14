package Lecture2;

public class Users extends Thread{
	
	private ATM atm;
	private int money;
	private String message;
	private String name;
	
	public Users(ATM atm, int money){
		this.atm=atm;
		this.money=money;
		message=" ";
		name=getName();
	}
	
	
	public void run(){
		message=atm.drawMoney(money);
		System.out.println(getName()+"  " +message);
	}

}
