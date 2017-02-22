import java.util.ArrayList;


public class Rider extends Piece {
	
	
	public Rider(String i, String p, int c) {
		// TODO Auto-generated constructor stub
		
			setId(i);
			setPath(p);
			setColor(c);
			
	}

	@Override
	public ArrayList<Cell> move(Cell[][] state, int x, int y) {
		
		possibleMoves.clear();
		
		if(getColor()==0)
		{
			if(x==0)
				return possibleMoves;
			
			if(state[x-1][y].getPiece()==null)
			{
				possibleMoves.add(state[x-1][y]);
				if(x==6)
				{
					if(state[4][y].getPiece()==null)
						possibleMoves.add(state[4][y]);
				}
			}
			if((y>0)&&(state[x-1][y-1].getPiece()!=null)&&(state[x-1][y-1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(state[x-1][y-1]);
			if((y<7)&&(state[x-1][y+1].getPiece()!=null)&&(state[x-1][y+1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(state[x-1][y+1]);
		}
		else
		{
			if(x==8)
				return possibleMoves;
			if(state[x+1][y].getPiece()==null)
			{
				possibleMoves.add(state[x+1][y]);
				if(x==1)
				{
					if(state[3][y].getPiece()==null)
						possibleMoves.add(state[3][y]);
				}
			}
			if((y>0)&&(state[x+1][y-1].getPiece()!=null)&&(state[x+1][y-1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(state[x+1][y-1]);
			if((y<7)&&(state[x+1][y+1].getPiece()!=null)&&(state[x+1][y+1].getPiece().getColor()!=this.getColor()))
				possibleMoves.add(state[x+1][y+1]);
		}
		return possibleMoves;
	}

}
