import java.util.*;

class Solution{

	public int[] price;
	public long[][] maxP;
	public int n;

public static void main(String[] args){

Scanner sc = new Scanner(System.in);
Solution stock= new Solution();

System.out.print("No. of days: ");
stock.n= sc.nextInt();  //length of stock period
stock.maxP = new long[stock.n][2]; //lookup table for DP solution
int x =0 ;
//System.out.print("Initial no. of stocks: ");
//x= sc.nextInt();
System.out.println("Enter stock prices for each day:");

stock.price = new int[stock.n];
for(int i=0;i<stock.n;i++){
stock.price[i]=sc.nextInt();
stock.maxP[i][0]=-1;
stock.maxP[i][1]=-1;
}

System.out.println("Max. profit: " + stock.maxProfit(stock.n,x));

}

//numDaysLeft represents no. of days left till end of stock period
//numStocks represents no. of stocks you have currently
long maxProfit(int numDaysLeft,int numStocks){
	int profit;
	if(numDaysLeft == 0 ){
		//stocks left but no days left
		//profit = 0;
		return 0;
	}

else{
	int i=numDaysLeft, x=numStocks;
	//getting current day from no. of days left till the end of stock period
int currentDay = n - numDaysLeft;

//if(maxP[i][x]!=-1) return maxP[i][x];

	if(x==1){
		if(maxP[i-1][1]!=-1) return maxP[i-1][1];
		maxP[i-1][1] = max(maxProfit(i-1,1),maxProfit(i-1,2)-price[currentDay],maxProfit(i-1,0)+price[currentDay]);
		return maxP[i-1][1];
	}else if(x==0){
		if(maxP[i-1][0]!=-1) return maxP[i-1][0];
		maxP[i-1][0] = max(maxProfit(i-1,0),maxProfit(i-1,1)-price[currentDay],maxProfit(i-1,0));
		return maxP[i-1][0];
	}else{
		long m,c;
		//if(maxP[i-1][0]!=-1) c= maxP[i-1][0];
		//else 
			c = maxProfit(i,0);
		//if(maxP[i-1][1]!=-1) m= maxP[i-1][1];
		//else 
			m = maxProfit(i,1) - c;
		return m*x + c;
	}
}
	//System.out.println("Profit ("+numDaysLeft+","+numStocks+") = "+ profit);
	//return profit;
}


long max(long a,long b,long c){
	if(a>=b&&a>=c) return a;
	if(b>=a&&b>=c) return b;
	if(c>=a&&c>=b) return c;
	return 0;
}

}



