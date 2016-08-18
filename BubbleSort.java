import java.util.*;

class BubbleSort{
	
public static int bubblesort(int[] arr){
	System.out.println("Bubble sort...begin.");
        int count=0;
        boolean swapped;
        for(int i=arr.length - 1;i>0;i--){
            swapped = false;
            for(int j=0;j<i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1] = temp;
                    count++;
                    swapped = true;
                }
            }
            if(!swapped) break;
            printArray(arr);
        }
        return count;
    }

    private static void printArray(int[] arr) {
      for(int n: arr){
         System.out.print(n+" ");
      }
        System.out.println("");
   }


}