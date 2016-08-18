import java.util.*;

class Solution{
	
public static void main(String[] args){

	Scanner sc = new Scanner(System.in);

	System.out.print("Number of students? ");
	int n=sc.nextInt();
	int arr[] = new int[n+2];
	int lookup[]=new int[n+2];

	System.out.println("Enter score of each student.");
	/*
		In the loop below, i goes from 1st to second last element so that
        OutOfBounds exception is not raised while the DP algorithm is executing.
		An irrelevant value is put in first and last elements of array
		so that it doesn't affect the solution.
	*/
	for(int i=1;i<(n+1);i++){
		arr[i]=sc.nextInt();
		lookup[i]= -1;
	}

	//putting irrelevant value in last and first position of array
	arr[0]=arr[1];
	arr[n+1] = arr[n];
	//lookup[0]=0;

	//System.out.println("Candies needed: "+ candiesSolver1(arr,n));
	System.out.println("Candies needed: "+ candiesSolver2(arr,lookup,n));
}

//Dynamic Programming helper function
	private static long candiesSolver2(int[] arr,int[] lookup,int n){
		long candies=0;
		for(int i=1;i<n+1;i++){
			candies+=func(arr,lookup,i);
		}
		return candies;
	}

//Dynamic Programming Solution
	private static int func(int[] arr,int[] lookup,int i){
		if(lookup[i] != -1){
				return lookup[i];
			}
		else if(arr[i]<=arr[i-1]){
			if(arr[i]>arr[i+1]){
				lookup[i]=func(arr,lookup,i+1) + 1;
				return lookup[i];
			}
			else{
				lookup[i]=1;
				return 1;
			}
		}else/*if (arr[i]>arr[i-1])*/{
			if(arr[i]>arr[i+1]){
				lookup[i]= max(func(arr,lookup,i-1),func(arr,lookup,i+1)) + 1;
				return lookup[i];
			}
			else{
				lookup[i]=func(arr,lookup,i-1) + 1;
				return lookup[i];
			}
		}
	}


//Iterative solution (doesn't work for all test cases)
	private static long candiesSolver1(int[] arr,int n){
		int i=0;
		long candies=1;
	while(i<n){
		candies--;
		int eq_seq_len=1,inc_seq_len=1,dec_seq_len=1;
		try{
			while(arr[i+1]==arr[i]){
				eq_seq_len++;
				i++;
			}
			while(arr[i+1]>arr[i]){
				inc_seq_len++;
				i++;
			}
			while(arr[i+1]<arr[i]){
				dec_seq_len++;
				i++;
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Exception caught.");
			i++;
		}
		//candies+= (eq_seq_len-1) + naturalSum(max(inc_seq_len,dec_seq_len)) + naturalSum(min(inc_seq_len,dec_seq_len)-1);
		candies+=(eq_seq_len-1);
		if(inc_seq_len>dec_seq_len){
			candies+=naturalSum(inc_seq_len) + naturalSum(dec_seq_len - 1);
		}else{
			candies+=naturalSum(dec_seq_len) + naturalSum(inc_seq_len - 1);
		}

	}
	return candies;
}


	//sum of first n natural numbers
	private static long naturalSum(int n){
		return (long)(n*(n+1)/2);
	}

	private static int max(int a,int b){
		if(a>b) return a;
		return b;
	}

	private static int min(int a,int b){
		if(a<b) return a;
		return b;
	}

}