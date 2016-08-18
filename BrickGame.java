import java.io.*;
import java.util.*;
import java.lang.Math;

class Solution {

    int n;
    int[] a;
    long[] lookup,prefixSum;

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
            Solution sol = new Solution();
            System.out.print("Enter num of bricks: ");
            sol.n = sc.nextInt();
            System.out.println("Enter value of each brick: ");
            sol.a = new int[sol.n];
            for(int i=0;i<sol.n;i++){
                sol.a[i]=sc.nextInt();
            }
            //add code to reverse the array
            //so that value of last brick is stored in 0th element
            //print(sol.a);
            sol.reverse(sol.a);
            print(sol.a);
            System.out.println("Maximum score: "+ sol.maxScore());
        }
    }

//Bottom up DP approach
    private long maxScore(){
        //System.out.println("Inside maxScore no param");
        //to store cumulative sum of the array of brick values
        prefixSum = new long[n];
        prefixSum[0]=a[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=prefixSum[i-1]+a[i];
        }

        lookup = new long[n];
        lookup[0]=a[0];
        lookup[1]=a[0]+a[1];
        lookup[2]=a[0]+a[1]+a[2];

        for(int i=3;i<n;i++){
            long move1,move2,move3;
            move1 = a[i] + (prefixSum[i-1] - lookup[i-1]);
            move2 = a[i] + a[i-1] + (prefixSum[i-2] - lookup[i-2]);
            move3 = a[i] + a[i-1] + a[i-2] + (prefixSum[i-3] - lookup[i-3]);
            lookup[i]=Math.max(move1,Math.max(move2,move3));
        }
        return lookup[n-1];
    }

    private void reverse(int[] a){
        for(int i=0,n=a.length-1;i<a.length/2;i++,n--){
            int temp=a[i];
            a[i]=a[n];
            a[n]=temp;
        }
    }


    public static long max(long a,long b,long c){
    	if(a>=b && a>=c) return a;
    	if(b>=a && b>=c) return b;
    	if(c>=a && c>=b) return c;
        return 0;
    }

    public static long min(long a,long b,long c){
    	if(a<=b && a<=c) return a;
    	if(b<=a && b<=c) return b;
    	if(c<=a && c<=b) return c;
        return 0;
    }


    private long maxScore(int i,boolean turn){
        //System.out.print("maxScore(" +i+ " , " +n+ "): ");
        if(lookup[i]!=-1) return lookup[i];
        /*
    	//if(i>=n) return 0;
    	if(n-i<4){
    		int x=0;
    		try{
    		x+=a[i];
    		x+=a[i+1];
    		x+=a[i+2];
        //System.out.println(x);
            return x;

    	}catch(ArrayIndexOutOfBoundsException e){
           //System.out.println("Exception caught. Return: " +x);
    		return x;
    	}
    }

    int move1,move2,move3;
    move1=a[i] + mid(maxScore(a,i+2,n),maxScore(a,i+3,n),maxScore(a,i+4,n));
    move2=a[i] + a[i+1] + mid(maxScore(a,i+3,n),maxScore(a,i+4,n),maxScore(a,i+5,n));
    move3=a[i] +a[i+1] + a[i+2] + mid(maxScore(a,i+4,n),maxScore(a,i+5,n),maxScore(a,i+6,n));
    //System.out.println()

    return max(move1,move2,move3);
    */

    //if Player 1's turn
    if(turn){
        //Base case
        if(n-i<4){
            long x=0;
            try{
            x+=a[i];
            x+=a[i+1];
            x+=a[i+2];
        //System.out.println(x);
            return x;

        }catch(ArrayIndexOutOfBoundsException e){
           //System.out.println("Exception caught. Return: " +x);
            return x;
        }
    }

        lookup[i]= max(a[i]+maxScore(i+1,false), a[i]+a[i+1]+maxScore(i+2,false), a[i]+a[i+1]+a[i+2] + maxScore(i+3,false));
        return lookup[i];
    }

    //if Player 2's turn
    else{
        //Base case
        if(n-i<4){
            return 0; //0 because player1 gets nothing if player 2 makes last turn
        }
        long move1,move2,move3;
        move1 = a[i]+maxScore(i+1,true);
        move2 = a[i]+a[i+1]+maxScore(i+2,true);
        move3 = a[i]+a[i+1]+a[i+2] + maxScore(i+3,true);
        long maximum = max(move1,move2,move3);
        if(maximum==move1) {lookup[i]= maxScore(i+1,true); return lookup[i];}
        if(maximum==move2) {lookup[i]= maxScore(i+2,true); return lookup[i];}
        if(maximum==move3) {lookup[i]= maxScore(i+3,true); return lookup[i];}
    }

return 0;
}


}