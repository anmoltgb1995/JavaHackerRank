import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no. of elements: ");
        int n = in.nextInt();
        int a[] = new int[n];
        System.out.println("Enter values of elements.");
        for(int A_i=0; A_i < n; A_i++){
            a[A_i] = in.nextInt();
        }
        int min = n;
        for(int i =0;i<n-1;i++){
        	System.out.println("i="+i+", min="+min);
            for(int j=i,dist=1;dist<min;dist++){

            	if((j+dist) >= n) {
            		System.out.println((j+dist)+"th element is out of scope. Break exec.");
	            	break;
            	}
            	System.out.println("Comparing "+(j+dist)+"th element with "+j+"th element.");
                if(a[j+dist]==a[j]){
                    min=dist;
                    if(min==1){
                    	System.out.println("Minimum value reached");
                        System.out.println("1");
                        return;
                    }
                    break;
                }
            }
        }
        System.out.println("Minimum distance= " + (min==n ? -1 : min));
    }
}
