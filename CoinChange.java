import java.util.*;

class Solution{
	public static void main(String[] args){
		Scanner sc =  new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] c=new int[m];
		int[] lookup=new int[n];

		for(int i=0;i<m;i++){
			c[i]=sc.nextInt();
		}

		Arrays.sort(c);
		System.out.println("Total possible ways: " + coinSolver(n,c,lookup));

	}

	private static int coinSolver(int n,int[] c,int[] lookup){
		if(i<)
		for(int i=0,sum=0;i<c.length;i++){
			sum+=coinSolver(n-c[i],c,lookup);
		}
		return sum;
	}

}