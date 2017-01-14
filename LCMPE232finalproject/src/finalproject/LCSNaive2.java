package finalproject;

public class LCSNaive2 {
	
	public int lcsLength(String X, String Y, int m, int n){
		int length=0;
		
		if(m==0||n==0){
			length= length;
		}
		else if(X.charAt(m)==Y.charAt(n)){
			length= length+ 1+ lcsLength(X, Y, m-1, n-1);
		}
		else{ 
			length= length+ Math.max(lcsLength(X, Y, m, n-1), lcsLength(X, Y, m-1, n));
		}
		return length;
	}
	
	public static void main(String[] args) {
		LCSNaive2 lcs=new LCSNaive2();
		String A="p›nars";
		String B="fehimes";
		int i=A.length();
		int j=B.length();
		
		lcs.lcsLength(A, B, i, j);
	}

}
