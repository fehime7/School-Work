
public class TestHouse {
	public static void main(String[] args) {
		House h=new House(4,"gop",100.00,90.00,true);
		/*h.setArea(90.0);
		h.setLocation("Sar›göl");
		h.setPrice(250.00);
		h.setRoomNumber(4);
		h.setAvailable(true);*/
		System.out.println(h.getArea());
		System.out.println(h.getLocation());
		System.out.println(h.getPrice());
		System.out.println(h.getRoomNumber());
		System.out.println(h.getAvailable());
		
	}

}
