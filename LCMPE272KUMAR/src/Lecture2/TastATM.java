package Lecture2;

public class TastATM {
	public static void main(String[] args) {
		
		ATM atm=new ATM(600);
		Users ahmet=new Users(atm, 400);
		Users mehmet=new Users(atm, 300);
		ahmet.setName("Ahmet");
		mehmet.setName("Mehmet");
		
		ahmet.start();
		mehmet.start();
		
	}

}
