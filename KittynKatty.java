import java.io.*;
import java.util.*;
import java.lang.Boolean;

class Solution {

	public int N;
    private Boolean dp[][][];
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        System.out.print("Enter no.of test cases: ");
        int t = in.nextInt();
        while(t-->0){
        	Solution sol = new Solution();
        	System.out.print("Enter no.of boxes: ");
            sol.N = in.nextInt();
            int q=sol.N/3;
            int zeros=q,ones=q,twos=q;

            if(sol.N%3==1){
            	ones+=1;
                sol.dp = new Boolean[2][2][2];
            }else if(sol.N%3==2){
            	ones+=1;
            	twos+=1;
                sol.dp = new Boolean[2][2][2];
            }
            else {
                sol.dp = new Boolean[2*q+1][2*q+1][2*q+1];
            }

            System.out.println(sol.canKittyWin(zeros,ones,twos,sol.N).booleanValue() ? "Kitty":"Katty");

        }

    }

//Top-down DP approach
    private Boolean canKittyWin(int zeros,int ones,int twos,int n){
        //System.out.println("n="+n);

        //Invalid case
        if(zeros<0||ones<0||twos<0) {
            //System.out.println("Base case: f("+zeros+","+ones+","+twos+") = " + "Invalid case"); 
            return (!( (N-n)%2==0  ));
        }

        if(dp[zeros][ones][twos]!=null) return dp[zeros][ones][twos];

        //Base case
        if(n==1){
            if(ones>0){
                dp[zeros][ones][twos]= new Boolean(true);
                //System.out.println("Base case: f("+zeros+","+ones+","+twos+") = " + dp[zeros][ones][twos]);
                return dp[zeros][ones][twos];
            }
            if(twos>0) {
                dp[zeros][ones][twos]= new Boolean(false);
                //System.out.println("Base case: f("+zeros+","+ones+","+twos+") = " + dp[zeros][ones][twos]);
                return dp[zeros][ones][twos];
            }

            dp[zeros][ones][twos] = new Boolean( (N%2==0) );
            //System.out.println("Base case: f("+zeros+","+ones+","+twos+") = " + dp[zeros][ones][twos]);
            return dp[zeros][ones][twos];
            //return dp[zeros][ones][twos];
        }

            boolean solution = !canKittyWin(zeros+1,ones,twos-2,n-1)||!canKittyWin(zeros+1,ones-1,twos-1,n-1)||
               !canKittyWin(zeros-1,ones,twos,n-1)||!canKittyWin(zeros,ones-1,twos,n-1)||
               !canKittyWin(zeros+1,ones-2,twos,n-1)||!canKittyWin(zeros-1,ones+1,twos-1,n-1)||
               !canKittyWin(zeros-1,ones-1,twos+1,n-1);
        //System.out.println("f("+zeros+","+ones+","+twos+") = " + dp[zeros][ones][twos]);
        dp[zeros][ones][twos] = new Boolean(solution);
        return dp[zeros][ones][twos];
        
    }

/*
    private boolean canKittyWin(int zeros,int ones,int twos,int n){

    	if(n==1){
    		if(ones>0) return true;
    		if(twos>0) return false;
    		else return (N%2==0);
    }

    if((N-n)%2==0){		//Kitty's turn
    //System.out.println("Kitty's move: ");
    	if(twos>0){
    		if(twos>1&&canKittyWin(zeros+1,ones,twos-2,n-1)) return true;
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
    		if(twos>1&&!canKittyWin(zeros+1,ones,twos-2,n-1)) return false;
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
*/

}