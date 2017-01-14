import java.awt.Color;
import java.awt.Frame;

public class Hello extends Frame{
	
	public Hello(){
		Color c= new Color(120, 200, 200);
	    setSize(300,300);
        setVisible(true);
        setTitle("Bilgi");
        setBackground(c);
       
	
	}
	
	
	public static void main(String[] args) {
		System.out.println("Hello User Interface...");
		new Hello();
	}

}
