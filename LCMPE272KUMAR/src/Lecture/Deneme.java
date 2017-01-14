package Lecture;

public class Deneme {
	
	public void printElement(int [][] table){
		
		try{
		int len=table.length;
		for (int i=0; i<=len;i++){
			for(int j=0; j<=i; j++){
				System.out.print(table[i][j]+" ");
				
				
			}
			System.out.print("\n");
		}
	}
		catch(Exception e){ }}
	
	public static void main(String[] args) {
		int [][] t={{1,2,3,}, {1,2,3}, {1,2,3}};
		
		Deneme d=new Deneme();
		d.printElement(t);
	}

}
