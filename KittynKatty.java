import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class sample {

	public int N;
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no.of test cases: ");
        int t = in.nextInt();
        while(t-->0){
        	sample samp = new sample();
        	System.out.print("Enter no.of boxes: ");
            samp.N = in.nextInt();
            int q=samp.N/3;
            int zeros=q,ones=q,twos=q;
            if(samp.N%3==1){
            	ones+=1;
            }else if(samp.N%3==2){
            	ones+=1;
            	twos+=1;
            }

            System.out.println(samp.canKittyWin(zeros,ones,twos,samp.N) ? "Kitty":"Katty");

        }

    }

    private boolean canKittyWin(int zeros,int ones,int twos,int n){

    	if(n==1){
    		if(ones>0) return true;
    		if(twos>0) return false;
    		else return (N%2==0);
    }

    if((N-n)%2==0){		//Kitty's turn
    //System.out.println("Kitty's move: ");
    	if(twos>0){
    		if(twos>1&&canKittyWin(zeros+1,ones,twos+2,n-1)) return true;
    		if(ones>0&&(canKittyWin(zeros,ones,twos-1,n-1)||canKittyWin(zeros,ones-1,twos,n-1))) return true;
    		if(zeros>0&&(canKittyWin(zeros-1,ones,twos,n-1)||canKittyWin(zeros-1,ones+1,twos-2,n-1))) return true;
    	}
    	//if(ones>0){
    		if(ones>1&&canKittyWin(zeros+1,ones-2,twos,n-1)) return true;
    		if(ones>0&&zeros>0&&(canKittyWin(zeros-1,ones,twos,n-1)||canKittyWin(zeros-1,ones-1,twos+1,n-1))) return true;
    	//}
    	if(zeros>1&&canKittyWin(zeros-1,ones,twos,n-1)) return true;

    		return false;
    }

    else{			//Katty's turn
    //System.out.println("Katty's move: ");
    	if(twos>0){
    		if(twos>1&&!canKittyWin(zeros+1,ones,twos+2,n-1)) return false;
    		if(ones>0&&(!canKittyWin(zeros,ones,twos-1,n-1)||!canKittyWin(zeros,ones-1,twos,n-1))) return false;
    		if(zeros>0&&(!canKittyWin(zeros-1,ones,twos,n-1)||!canKittyWin(zeros-1,ones+1,twos-2,n-1))) return false;
    	}
    	//if(ones>0){
    		if(ones>1&&!canKittyWin(zeros+1,ones-2,twos,n-1)) return false;
    		if(ones>0&&zeros>0&&(!canKittyWin(zeros-1,ones,twos,n-1)||!canKittyWin(zeros-1,ones-1,twos+1,n-1))) return false;
    	//}
    	if(zeros>1&&!canKittyWin(zeros-1,ones,twos,n-1)) return false;

    		return true;

    }

}

}