import java.io.*;
import java.util.*;

class Solution {

    public static void insertionSort(int[] ar)
    {       
        for(int i=1;i<ar.length;i++){
            int var = ar[i];
            //reverse traverse into sorted array
            for(int j=i;j>=0;j--){
               //if found correct position
            if(j==0 || ar[j-1]<=var){
                ar[j]=var;
                break;
            }
            //else shift one element to right
            else{
                ar[j]=ar[j-1];
            }
            }
            printArray(ar);
        }
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter num elements : ");
       int s = in.nextInt();
       int[] ar = new int[s];
       System.out.println("Enter values: ");
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       //insertionSort(ar);
       System.out.println("Num swaps: " + BubbleSort.bubblesort(ar));
       printArray(ar);
                    
    }
        
    public static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
