import java.io.*;
import java.util.*;
import java.lang.Math;

class Solution {

    private static void print(long[] a){
		System.out.println();
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter num of test cases: ");
    	int t =sc.nextInt();
    	while(t-- > 0){
    		System.out.print("Enter num of elements in array: ");
    		int n=sc.nextInt();
    		int[] a = new int[n];
    		long[] p = new long[n];
    		
    		System.out.println("Enter value of each element: ");
    		a[0]=sc.nextInt();
    		p[0]=a[0];
    		for(int i=1;i<n;i++){
    			a[i] = sc.nextInt();
    			p[i] = p[i-1]+a[i];
    		}
    		//System.out.println("Division point is: " + binarySearch(p,0,n-1,0,n-1));
    		System.out.println("Max score: " + (p[n-1] == 0? n-1 : maxScore(p,0,n-1)));
    	}
    }

    private static int binarySearch(long[] p, int i,int j,int start,int end){
    	//Scanner sc = new Scanner(System.in);
    	//System.out.println("i= "+i+",j= "+j);
    	//sc.nextInt();
    	if(i>=j) return -1;
    	int mid = (i+j)/2;
    	//System.out.println("mid= "+mid);
    	long sumLeft=0,sumRight=0;
    	try{
    		sumLeft = p[mid]-p[start-1];
    		sumRight = p[end]-p[mid];
    	}catch(ArrayIndexOutOfBoundsException e){
    		//System.out.println("Exception.");
    		sumLeft = p[mid];
    		sumRight = p[end]-p[mid];
    	}

    	if(sumLeft==sumRight) return mid;
    	if(sumLeft>sumRight) return binarySearch(p,i,mid,start,end);
    	return binarySearch(p,mid+1,j,start,end);
    }

    private static int maxScore(long[] p,int i,int j){
    	//Scanner sc = new Scanner(System.in);
    	//sc.nextInt();
    	//System.out.println("i= "+i+",j= "+j);
    	if(i>=j) return 0;
    	int m = binarySearch(p,i,j,i,j);
    	//System.out.println("m= "+m);
    	if(m == -1) return 0;
    	return 1 + Math.max(maxScore(p,i,m),maxScore(p,m+1,j));

    }
}