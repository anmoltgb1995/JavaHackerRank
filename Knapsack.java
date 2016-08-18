import java.util.*;

/*
Recursive solution for unbounded knapsack problem
*/

class Solution{

	public static void main(String[] args){
		Scanner sc =  new Scanner(System.in);
		System.out.print("Enter no. of test cases: ");
		int t=sc.nextInt();
		while(t-->0){
		System.out.print("Enter no. elements in array: ");
		int n=sc.nextInt();
		System.out.print("Enter expected sum: ");
		int k=sc.nextInt();
		int[] arr=new int[n];
		int[] lookup=new int[n];

		System.out.print("Enter elements: ");
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}

		System.out.println("Nearest possible sum: " + knapsack(arr,n-1,k));
	}

	}

	private static int knapsack(int[] arr,int n, int k){
		if(n==0) return (k/arr[n]) * arr[n];
		if(k<1) return 0;
		if(arr[n]>k) return knapsack(arr,n-1,k);
		return max(knapsack(arr,n-1,k),arr[n] + knapsack(arr,n,k-arr[n]));
	}

	private static int max(int a,int b){
		if(a>b) return a;
		return b;
	}

}