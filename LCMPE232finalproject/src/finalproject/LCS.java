package finalproject;

import java.io.BufferedReader;
import java.io.FileReader;

public class LCS {
	private int NEITHER = 0;
	private int UP= 1;
	private int LEFT= 2;
	private int UP_AND_LEFT = 3;

	public String lcsAlg(String x, String y) {
		int n = x.length();
		int m = y.length();
		int C[][] = new int[n+1][m+1];
		int B[][] = new int[n+1][m+1];
		int i, j;

		for( i = 0; i <= n; i++){
			C[i][0] = 0;
			B[i][0] = UP;
		}
		for( j = 0; j <= m; j++) {
			C[0][j] = 0;
			B[0][j] = LEFT;
		}

		for( i = 1; i <= n; i++) {
			for( j = 1; j <= m; j++) { 
	
				if( x.charAt(i-1) == y.charAt(j-1) ) {
					C[i][j] = C[i-1][j-1] + 1;
					B[i][j] = UP_AND_LEFT;
				}

				else {
					C[i][j] = C[i-1][j-1] + 0;
					B[i][j] = NEITHER;
				}

			    if( C[i-1][j] >= C[i][j] ) {	
					C[i][j] = C[i-1][j];
					B[i][j] = UP;
				}

				if( C[i][j-1] >= C[i][j] ) {
					C[i][j] = C[i][j-1];
					B[i][j] = LEFT;
				}
			}
		}

        i = n; 
	    j = m;
		int position = C[i][j] - 1;
		char lcs[] = new char[ position+1 ];

		while( i > 0 || j > 0 ) {
			if( B[i][j] == UP_AND_LEFT ) {
				i--;
				j--;
				lcs[position--] = x.charAt(i);
			}
	
			else if( B[i][j] == UP ) {
				i--;
			}
	
			else if( B[i][j] == LEFT ) {
				j--;
			}
		}

		return new String(lcs);
	}

	public static void main(String args[]) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("file1.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));
			
		
			LCS l=new LCS();
			
			System.out.println(l.lcsAlg("I am the lcs finder ","I am fehime seven"));
			System.out.println(l.lcsAlg("110100001001100", "10010010001001100"));
//			System.out.println(l.lcsAlg(br, br2));
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

