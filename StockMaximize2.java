import java.util.*;

class Solution{

	public int[] price;
	public int[][] profit;
	public int n;

public static void main(String[] args){

Scanner sc = new Scanner(System.in);
Solution stock= new Solution();

System.out.print("No. of days: ");
stock.n= sc.nextInt();  //length of stock period
//sc.nextLine();
int x =0 ;
//System.out.print("Initial no. of stocks: ");
//x= sc.nextInt();
System.out.println("Enter stock prices for each day:");

stock.price = new int[stock.n];
for(int i=0;i<stock.n;i++){
stock.price[i]=sc.nextInt();
}

System.out.println("Max. profit: " + stock.maxProfit(stock.n,x));

}

//numDaysLeft represents no. of days left till end of stock period
//numStocks represents no. of stocks you have currently
int maxProfit(int numDaysLeft,int numStocks){
	int profit;
	if(numDaysLeft == 0 ){
		//stocks left but no days left
		profit = 0;
	}

else{
int profitIfBuy,profitIfSell=0,profitIfNothing;
//getting current day from no. of days left till the end of stock period
int currentDay = n - numDaysLeft;
profitIfBuy = maxProfit(numDaysLeft-1,numStocks+1) - price[currentDay];

//you can only sell if you have some stocks
if(numStocks > 0) 
	profitIfSell = maxProfit(numDaysLeft-1,0) + (price[currentDay] * numStocks);
else profitIfSell = 0;
profitIfNothing = maxProfit(numDaysLeft-1,numStocks);

	profit = max(profitIfBuy,profitIfSell,profitIfNothing);
}
	System.out.println("Profit ("+numDaysLeft+","+numStocks+") = "+ profit);
	return profit;
}


int max(int a,int b,int c){
	if(a>=b&&a>=c) return a;
	if(b>=a&&b>=c) return b;
	if(c>=a&&c>=b) return c;
	return 0;
}

}



