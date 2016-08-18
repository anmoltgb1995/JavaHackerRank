import java.io.*;
import java.util.*;
import java.lang.Math;

class Solution {

    private static void print(int[] a){
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num of test cases: ");
        int t = sc.nextInt();

        while(t-- > 0){
            //Solution sol = new Solution();
            System.out.print("Enter N: ");
            int n = sc.nextInt();
            System.out.println("Enter values of array b[i]: ");
            int[] b = new int[n];
            for(int i=0;i<n;i++){
                b[i]=sc.nextInt();
            }

            //print(sol.a);
            System.out.println("Maximum cost: "+ maxCost(b,n));
        }
    }

//Bottom up DP approach
	private static int maxCost(int[] b,int n){
		int[][] a = new int[n][2];
		//cost is zero when only single element is there
		a[0][0] = 0;
		a[0][1] = 0;

		for(int i=1;i<n;i++){
			//cost of array a(from i to n) when a[i] is taken as 1
			a[i][0] = Math.max( a[i-1][0] , Math.abs(1-b[i-1]) + a[i-1][1] );
			//cost of array a(from i to n) when a[i] is taken as b[i]
			a[i][1] = Math.max( b[i]-1 + a[i-1][0] , Math.abs(b[i]-b[i-1]) + a[i-1][1] );
		}
		return Math.max(a[n-1][0],a[n-1][1]);
	}

}