import java.util.*;
import java.math.BigInteger;

class FibonacciMod{
	public BigInteger a,b;
	public BigInteger[] lookup = new BigInteger[20];
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		FibonacciMod fib = new FibonacciMod();
		fib.a=sc.nextBigInteger();
		fib.b=sc.nextBigInteger();
		int n=sc.nextInt();
		for(int i=0;i<n;i++) fib.lookup[i]= BigInteger.valueOf(-1);

		System.out.println(fib.computeVal(n));

	}

	public BigInteger computeVal(int n){
		if(n==1) return a;
		if(n==2) return b;
		if(lookup[n-1]!=BigInteger.valueOf(-1)) return lookup[n-1];
		BigInteger x=computeVal(n-1);
		lookup[n-1] = (x.multiply(x)).add(computeVal(n-2));
		System.out.println("Value("+n+")="+lookup[n-1]);
		return lookup[n-1];
	}
}