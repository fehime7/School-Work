import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.*;

public class RustlerInterface extends JFrame implements MouseListener{
	
	static Rider br1,br2,br3,br4, wr1, wr2, wr3,wr4;
	static Horse bh, wh;
	Cell c, previous;
	private int chance=0;
	private Cell boardState[][];
	private ArrayList<Cell> destinationlist = new ArrayList<Cell>();
	private Player White=null,Black=null;
	private boolean selected=false,end=false;
	Player whitePlayer, blackPlayer, winner;
	static String move;
	private Player tempPlayer;
	private BufferedImage image;
	private JPanel board;
	
	public static void main(String[] args) {
   
		
		wr1 = new Rider("WR1", "White_Pawn.png", 0);
		wr2 = new Rider("WR2", "White_Pawn.png", 0);
		wr3 = new Rider("WR3", "White_Pawn.png", 0);
		wr4 = new Rider("WR4", "White_Pawn.png", 0);
		wh = new Horse("WH", "White_Horse.png", 0);
		br1 = new Rider("BR1", "Black_Pawn.png", 1);
		br2 = new Rider("BR2", "Black_Pawn.png", 1);
		br3 = new Rider("BR3", "Black_Pawn.png", 1);
		br4 = new Rider("BR4", "Black_Pawn.png", 1);
		bh = new Horse("BH", "Black_Horse.png", 1);
		
		RustlerInterface rustlar=new RustlerInterface();
	
	}		
	
	public RustlerInterface(){
		
		
		setSize(800,650);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Cell cell;
		Piece P;
		board=new JPanel(new GridLayout(7,7));
		//board.setBorder(BorderFactory.createLoweredBevelBorder());
		board.setBounds(0,0,600,600);
		board.setLocation(20,0);
		
		boardState= new Cell [7][7];
		
		for(int i=0;i<7;i++)
			for(int j=0;j<7;j++)
			{	
				P=null;
				if(i==0&&j==2)
					P=br1;
				else if(i==0&&j==4)
					P=br2;
				else if(i==2&&j==0)
					P=br3;
				else if(i==4&&j==0)
					P=br4;
				else if(i==2&&j==2)
					P=bh;
				else if(i==6&&j==4)
					P=wr1;
				else if(i==6&&j==2)
					P=wr2;
				else if(i==2&&j==6)
					P=wr3;
				else if(i==4&&j==6)
					P=wr4;
				else if(i==4&&j==4)
					P=wh;
				 
				cell=new Cell(i,j,P);
				cell.addMouseListener(this);
				board.add(cell);
				boardState[i][j]=cell;
			}
		
		add(board);
		setVisible(true);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d= (Graphics2D ) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.DARK_GRAY);
		
		/*
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 3; j++) {
				g2d.drawRect(70+i*70, 200+j*70, 70, 70);
				g2d.drawOval(70+i*70, 200+j*70, 70, 70);
			}
			
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				g2d.drawRect(210+i*70, 60+j*70, 70, 70);
				g2d.drawOval(210+i*70, 60+j*70, 70, 70);

			}	
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				g2d.drawRect(210+i*70, 410+j*70, 70, 70);
				g2d.drawOval(210+i*70, 410+j*70, 70, 70);

			}	
		}
		*/
		
		
	}	
	
	  // It checks if the horse of given color is captured. If true then the game is finished and other player wins 
	  public boolean isSurraunded(int color){
		  
		  
		return false;  
	  }
	
	 private void cleanDestinations(ArrayList<Cell> destList)      //Function to clear the last move's destinations
	    {
	    	ListIterator<Cell> it = destList.listIterator();
	    	while(it.hasNext())
	    		it.next().removePossibleDestination();
	    }
	 
	//A function that indicates the possible moves by highlighting the Cells
	    private void highlightDestinations(ArrayList<Cell> destList)
	    {
	    	ListIterator<Cell> it = destList.listIterator();
	    	while(it.hasNext())
	    		it.next().setPossibleDestination();
	    }
	
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		c=(Cell)e.getSource();
		if (previous==null)
		{
			if(c.getPiece()!=null)
			{
				c.select();
				previous=c;
				destinationlist.clear();
				destinationlist=c.getPiece().move(boardState, c.x, c.y);
				
			}
			if(c.getPiece() instanceof Horse)
				return;
				//destinationlist=filterDestination(destinationlist,c);
			else
			{
				/*
				if(boardState[getHorse(chance).getx()][getKing(chance).gety()].ischeck())
					destinationlist = new ArrayList<Cell>(filterdestination(destinationlist,c));
				else if(destinationlist.isEmpty()==false && willkingbeindanger(c,destinationlist.get(0)))
					destinationlist.clear();
				*/
			}
			highlightDestinations(destinationlist);
		}	
		else
		{
			if(c.x==previous.x && c.y==previous.y)
			{
				c.deselect();
				cleanDestinations(destinationlist);
				destinationlist.clear();
				previous=null;
				
			}
			else if(c.getPiece()==null || previous.getPiece().getColor()!=c.getPiece().getColor()) {	
				if(c.isPossibleDestination()){
					if(c.getPiece()!=null)
						c.removePiece();
					c.setPiece(previous.getPiece());
					//c.setX(previous.getX());
					//c.setY(previous.getY());
					previous.removePiece();
				}
				if(previous!=null)
				{
					previous.deselect();
					previous=null;
				}
				cleanDestinations(destinationlist);
				destinationlist.clear();
				
			}else if(previous.getPiece().getColor()==c.getPiece().getColor())				
			{	
				previous.deselect();
				cleanDestinations(destinationlist);
				destinationlist.clear();
				c.select();
				previous=c;
				destinationlist=c.getPiece().move(boardState, c.x, c.y);
				
			}
			highlightDestinations(destinationlist);
		}	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
