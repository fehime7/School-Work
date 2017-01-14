
import java.nio.charset.Charset;
import java.nio.charset.*;

//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.io.*;

import java.util.Arrays;

public class LCSMem {
	static char[] charArray_file1_Content;
	static char[] charArray_file2_Content;
	static int[][] LCSArr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String file1_Content="";
		String file2_Content="";
		try {
			/*read files and save them into strings*/
			file1_Content = readFile("file3.txt", StandardCharsets.UTF_8);
			file2_Content = readFile("file4.txt", StandardCharsets.UTF_8);
			
			/*save strings to character arrays*/
			charArray_file1_Content = file1_Content.toCharArray();
			charArray_file2_Content = file2_Content.toCharArray();
			
			
			/*get length of each file*/
			int lengthOfFile1 = file1_Content.length();
			int lengthOfFile2 = file2_Content.length();

			LCSArr = new int[lengthOfFile1][lengthOfFile2];

			// Fill each row with -1 (Fill this array with -1)
			for (int[] row: LCSArr)
				Arrays.fill(row, -1);
			
			/*this is used in order to measure code execution time
			 * get current time in milliseconds
			 * */
			long startTimeMem = System.currentTimeMillis();
			int lengthSimilarMem= memoizedLCS(lengthOfFile1, lengthOfFile2, "");
			System.out.println("similar length memoizedLCS:" +lengthSimilarMem);
			long stopTimeMem = System.currentTimeMillis();
			long elapsedTimeMem = stopTimeMem - startTimeMem;
			System.out.println("execution time for MemoizedLCS:" + elapsedTimeMem + " msec\n");

			long startTimeBottomUp = System.currentTimeMillis();
			
			/*this method returns both string and length, i.e. ReturnVal object*/
			ReturnVal rtv = lcsBottomUpWithStr(lengthOfFile1, lengthOfFile2);
			
			/*get length of similar strings*/
			int lengthSimilarBottomUp= rtv.getIntValue();
			
			/*get similar string*/
			String stringSimilarBottomUp= rtv.getStrValue();

			System.out.println("similar length BottomUp:" +lengthSimilarBottomUp);

			long stopTimeBottomUp = System.currentTimeMillis();
			long elapsedTimeBottomUp = stopTimeBottomUp - startTimeBottomUp;
			System.out.println("execution time for BottomUpLCS:" + elapsedTimeBottomUp  + " msec\n");

			System.out.println("similar string:" +stringSimilarBottomUp);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String readFile(String path, Charset encoding) throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	static int max(int a, int b)
	{
		return (a > b)? a : b;
	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int lcs( char[] X, char[] Y, int m, int n, String str)
	{
		if (m == 0 || n == 0){
			return 0;  
		}
		if (X[m-1] == Y[n-1]){
			str+=X[m-1];
			return 1 + lcs(X, Y, m-1, n-1, str);  
		}
		else{
			return max(lcs(X, Y, m, n-1, str), lcs(X, Y, m-1, n, str));  
		}
	}

	static int memoizedLCS(int m, int n, String str)
	{
		int result=0;
		/*if we come to the end of one of strings, then return 0*/
		if (m == 0 || n == 0){
			return 0;
		}
		
		/*if the result of recursive function is already found
		 * if the array value is not -1, this means this index is already filled before
		 * here we do not need to call recursive function again. We have already this value in our hand.
		 * Ýf we found the result before, get this value from the array, otherwise make recursive call
		 * */
		if (LCSArr[m-1][n-1]!=-1) {
			return LCSArr[m-1][n-1];
		}
		
		/*if current characters are equal, increase length by one, call function with reduced values*/
		if (charArray_file1_Content[m-1] == charArray_file2_Content[n-1]){
			result=1+memoizedLCS(m-1,n-1,str);
		}
		/*if current characters are not equal, call recursive function twice with one by one reduced values*/
		else{
			result = max(memoizedLCS(m-1,n,str), memoizedLCS(m,n-1,str)); 
		}
		/*store result in the array for current index values*/
		LCSArr[m-1][n-1]=result;
		return result;
	}


	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static int lcsBottomUp(int m, int n )
	{
		int [][] L = new int [m+1][n+1];
		int i, j;

		/* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		for (i=0; i<=m; i++)
		{
			for (j=0; j<=n; j++)
			{
				if (i == 0 || j == 0)
					L[i][j] = 0;

				else if (charArray_file1_Content[i-1] == charArray_file2_Content[j-1])
					L[i][j] = L[i-1][j-1] + 1;
				else
					L[i][j] = max(L[i-1][j], L[i][j-1]);
			}
		}

		/* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
		return L[m][n];
	}

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	static ReturnVal lcsBottomUpWithStr(int m, int n )
	{
		ReturnVal [][] L = new ReturnVal [m+1][n+1];

		for (int i = 0; i < m+1; i++) {
			for (int j = 0; j < n+1; j++) {
				L[i][j] = new ReturnVal(0, "");
			}
		}

		int i, j;

		/* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
		for (i=0; i<=m; i++)
		{
			for (j=0; j<=n; j++)
			{
				if (i == 0 || j == 0){
					L[i][j].setIntValue(0);  
				}

				else if (charArray_file1_Content[i-1] == charArray_file2_Content[j-1]){
					L[i][j].setIntValue(L[i-1][j-1].getIntValue() + 1);
					L[i][j].setStrValue(L[i-1][j-1].getStrValue() + charArray_file1_Content[i-1]);
				}
				else
					L[i][j] = L[i-1][j].max(L[i][j-1]);
			}
		}

		/* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
		return L[m][n];
	}
}
