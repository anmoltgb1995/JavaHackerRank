import java.util.Scanner;

class MaxContSubarray {
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter size of array: ");
	int n=sc.nextInt();
	int[] arr=new int[n];
	for(int i=0;i<n;i++){
		arr[i]=sc.nextInt();
	}

	System.out.println("Max Sum: "+maxSum(arr,0,n-1));

	}

	static private int maxSum(int[] arr,int first,int last){
		if(first==last) return arr[first];
		return max(arr[first]+maxSum(arr,first+1,last),maxSum(arr,first+1,last));
	}

	static private int max(int a,int b){
		if(a>b) return a;
		return b;
	}
}