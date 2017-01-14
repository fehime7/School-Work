package finalproject;

public class LCSnaive {
	
	public int  lcsLength(  String X, String Y){
	int n=X.length();
	int m=Y.length();
	int [][] len=new int [n+1][m+1]; 

	
	 for (int i = 0; i < n; i++){
	      for (int j = 0; j < m; j++){
	          if (X.charAt(i) == Y.charAt(j))
	                len[i+1][j+1] = len[i][j] + 1;
	          else
	                len[i+1][j+1] =  Math.max(len[i+1][j], len[i][j+1]);
	     }
	 }
	return len [n][m];
    }
	
	public String lcsPrint(String X, String Y){
		int n=X.length();
		int m=Y.length();
		int [][] subsec=new int [n+1][m+1];
		
		for (int i = 0; i < n; i++){
		      for (int j = 0; j < m; j++){
		          if (X.charAt(i) == Y.charAt(j))
		        	  subsec[i+1][j+1] = subsec[i][j] + 1;
		          else
		        	  subsec[i+1][j+1] =  Math.max(subsec[i+1][j], subsec[i][j+1]);
		     }
		 }
		
		StringBuffer sb=new StringBuffer();
		
		while(n>0 && m>0){
			if(subsec[n][m]==subsec[n-1][m]){
				n--;
			}
			else if(subsec[n][m]==subsec[n][m-1]){
				m--;
			}
			else if(X.charAt(n-1)==Y.charAt(m-1)){
				sb.append(X.charAt(n-1));
				n--;
				m--;
				
			}
			
		}
		
		return sb.reverse().toString(); 
		
	}
	
	public int howMany(int n){
		return n;
		
	}
	
	
	public static void main(String[] args) {
		try{
		
	    LCSnaive lcsRun=new LCSnaive();
		System.out.println(lcsRun.lcsLength("1232424", "23472972"));
		System.out.println(lcsRun.lcsLength("I am the lcs finder ","I am fehime seven"));
		System.out.println(lcsRun.lcsPrint("1232424", "23472972"));
		System.out.println(lcsRun.lcsPrint("I am the lcs finder ","I am fehime seven"));
		
		}catch(Exception e){
			System.out.println("Your program is not working true"); 
		}
	}

}
