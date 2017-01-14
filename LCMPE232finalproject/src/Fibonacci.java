import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;
import java.io.*;
public class  Fibonacci{
	// Note: a treemap is used to store the fibonacci numbers that have already been calculated, also a biginteger is used to avoid loss of precision.
	static Map<Integer, BigInteger> memo = new TreeMap<Integer, BigInteger>();
	public static void main (String[] args) throws IOException{
		BufferedReader inKb = new BufferedReader (new InputStreamReader (System.in));
		System.out.println("Enter a number to calculate fibonacci value of that value:");
		int num = 0;
		int fibnum;
		num = Integer.parseInt(inKb.readLine());

		final long startTime = System.currentTimeMillis();
		System.out.println ("The memoized calculation of that value is: " + memoizedFibonacci(num));
		final long endTime = System.currentTimeMillis();

		System.out.println("Total execution time (memoized): " + (endTime - startTime) );

		final long startTime2 = System.currentTimeMillis();
		fibnum = fibonacci(num);
		System.out.println("the fibonacci value of " + num + "th is "+ fibnum);
		final long endTime2 = System.currentTimeMillis();
		System.out.println("Total execution time (recursive): " + (endTime2 - startTime2) );
	}
	static int fibonacci(int n) {
		if (n <= 1) {
			return 1;
			//the base case:If k <= 2 then fib(k) = 1.
		}	
		else {
			return fibonacci(n-1) + fibonacci(n-2);
			//if n > 2 then fibonnaci(n) = fibonacci(n-1) + fibonacci(n-2)
		}
	}
	static BigInteger memoizedFibonacci(int n)
	{
		if (n <= 1) return BigInteger.ONE;
		if (memo.get(n) == null)
		{
			//If the element is not in the treemap, we then calculate it and add it.
			memo.put(n, memoizedFibonacci(n-1).add(memoizedFibonacci(n-2)));
		}
		return memo.get(n); //return the treemap.
	}
}

