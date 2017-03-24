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
import java.util.Random;

import javax.swing.*;

public class RustlerInterface extends JFrame implements MouseListener{
	
	static Rider br1,br2,br3,br4, wr1, wr2, wr3,wr4;
	static Horse bh, wh;
	Cell c, previous, horseCell, aiCell;
	private int chance=0;
	private Cell boardState[][];
	public ArrayList<Cell> destinationlist = new ArrayList<Cell>();
	private Player White=null,Black=null;
	private boolean selected=false,end=false;
	Player whitePlayer, blackPlayer, winner;
	static String move;
	private Player tempPlayer;
	private JPanel board;
	JLabel player1, player2, hwosTern;
	MinMax mm ;
	boolean didWhiteplayed=false;
	
	public static void main(String[] args) {
   
		/*
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
		*/
		RustlerInterface rustler=new RustlerInterface();
		rustler.findHorse(0);
		rustler.findHorse(1);
	
	}		
	
	public RustlerInterface(){
		
		
		setSize(900,650);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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
		
		Cell cell;
		Piece P;
		board=new JPanel(new GridLayout(7,7));
		//board.setBorder(BorderFactory.createLoweredBevelBorder());
		board.setBounds(0,0,600,600);
		board.setLocation(20,20);
		
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
		
		player1= new JLabel("Player 1: Human Player - White");
		player1.setLocation(650, 50);
		player1.setSize(200, 50);
		
		player2= new JLabel("Player 2: MinMax Player - Black");
		player2.setLocation(650, 450);
		player2.setSize(200, 50);
		
		hwosTern= new JLabel("Tern : White Player");
		hwosTern.setLocation(650, 250);
		hwosTern.setSize(200, 50);
		
		
		add(board);
		add(player1);
		add(player2);
		add(hwosTern);
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
	
	public void makeRandomMove(){
		Random r=new Random();
		int x= r.nextInt(2);
		int y= r.nextInt(2);
		
		aiCell = boardState[0][2];
		boardState[x][y].setPiece(aiCell.getPiece());
		//aiCell.removePiece();
		
	
	}
	
	 public Cell findHorse(int color){
		 
		 for(int i=0; i<7; i++){
			 for(int j=0; j<7; j++){
				 if(boardState[i][j].getPiece() instanceof Horse && boardState[i][j].getPiece().getColor()==color){
					 horseCell = boardState[i][j];
					 break;
				 }
			 }
		 }
	
		 return horseCell;
	 }
	
	  // It checks if the horse of given color is captured. If true then the game is finished and other player wins 
	  public boolean isSurrounded(int color){
		  boolean result=false;
		  Cell c1= findHorse(color);
		  if(color==0 ){
			if(boardState[c1.getXPoz()-1][c1.getYPoz()].getPiece() instanceof Rider && boardState[c1.getXPoz()-1][c1.getYPoz()].getPiece().getColor()==1
			&& boardState[c1.getXPoz()+1][c1.getYPoz()].getPiece() instanceof Rider && boardState[c1.getXPoz()+1][c1.getYPoz()].getPiece().getColor()==1
			&& boardState[c1.getXPoz()][c1.getYPoz()-1].getPiece() instanceof Rider && boardState[c1.getXPoz()][c1.getYPoz()-1].getPiece().getColor()==1
			&& boardState[c1.getXPoz()][c1.getYPoz()+1].getPiece() instanceof Rider && boardState[c1.getXPoz()][c1.getYPoz()+1].getPiece().getColor()==1){
				
				//JOptionPane.showMessageDialog(null, "Game is finished.The winner is black player!!!");
				result=true;
			}
		  }
		  if(color==1){
			  if(boardState[c1.getXPoz()-1][c1.getYPoz()].getPiece() instanceof Rider && boardState[c1.getXPoz()-1][c1.getYPoz()].getPiece().getColor()==0
				&& boardState[c1.getXPoz()+1][c1.getYPoz()].getPiece() instanceof Rider && boardState[c1.getXPoz()+1][c1.getYPoz()].getPiece().getColor()==0
				&& boardState[c1.getXPoz()][c1.getYPoz()-1].getPiece() instanceof Rider && boardState[c1.getXPoz()][c1.getYPoz()-1].getPiece().getColor()==0
				&& boardState[c1.getXPoz()][c1.getYPoz()+1].getPiece() instanceof Rider && boardState[c1.getXPoz()][c1.getYPoz()+1].getPiece().getColor()==0){
					
					//JOptionPane.showMessageDialog(null, "Game is finished.The winner is white player!!!");
					result=true;
				}
			  }
		
		//System.out.println("isSurrounded works correct");  
		return result;  
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
			if(c.getPiece()!=null && c.getPiece().getColor()!=1 && didWhiteplayed == false)
			{
				c.select();
				previous=c;
				destinationlist.clear();
				destinationlist=c.getPiece().move(boardState, c.xPoz, c.yPoz);
				
			}
			//if(c.getPiece() instanceof Horse)
				//return;
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
			if(c.xPoz==previous.xPoz && c.yPoz==previous.yPoz)
			{
				c.deselect();
				cleanDestinations(destinationlist);
				destinationlist.clear();
				previous=null;
				
			}
			else if(c.getPiece()==null || previous.getPiece().getColor()!=c.getPiece().getColor()) {	
				if(c.isPossibleDestination()){
					if(c.getPiece()!=null){
						c.removePiece();
					}
					c.setPiece(previous.getPiece());
					previous.removePiece();
					didWhiteplayed=true;
					hwosTern.setText("Turn : Black Player");
					
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
				destinationlist=c.getPiece().move(boardState, c.xPoz, c.yPoz);
				
			}
			highlightDestinations(destinationlist);
		}
		if(isSurrounded(0)==true){
			JOptionPane.showMessageDialog(null, "Game is finished.The winner is black player!!!");
			System.out.println("isSurrounded works correct");
			
			

		}
		else if(isSurrounded(1)==true){
			JOptionPane.showMessageDialog(null, "Game is finished.The winner is white player!!!");
			System.out.println("isSurrounded works correct");  

		}
		if ( didWhiteplayed==true ){
			makeRandomMove();
			
			//aiCell.setPiece(boardState[0][2].getPiece());
			didWhiteplayed=false;
			hwosTern.setText("Turn : White Player");
					
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
