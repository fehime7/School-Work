
public class House {
	private int roomNumber;  // gives the number of rooms in the house
	private String location; // gives the city that house in
	private double price;    // selling price
	private double area;     // gives the area of house
	private boolean available; // shows if the house can be rented or not


	  
	public House(int roomNumber, String location, double price, double area,boolean available){
		this.roomNumber=roomNumber;
		this.location=location;
		this.price=price;
		this.area=area;
		this.available=available;
	}
	
	


	/*public void setRoomNumber(int a ){
		   a=roomNumber;
		   
	   }*/
	   public int getRoomNumber(){
		   return roomNumber;
		   
	   }

	   /*public void setLocation(String location){
		   this.location=location;
		   
	   }*/
	   public String getLocation(){
		   return location;
	   }
		   
	   
	   /*public void setPrice(double price){
		   this.price=price;
	   }*/
	   
	   public double getPrice(){
		   return price;		   
	   }
	   /*public void setArea(double area){
		   this.area=area;
	   }*/
	   public double getArea(){
		   return area;
	   }
	   /*public void setAvailable(boolean a){
		   a=true;
	   }*/
	   public boolean getAvailable(){
		   return true;
	   }
	}
   
