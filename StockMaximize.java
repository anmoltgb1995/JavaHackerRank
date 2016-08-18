/*
https://www.quora.com/Is-there-an-O-nlogn-algorithm-for-maximum-profit-from-buying-and-selling-stocks
*/

import java.util.*;

class StockMaximize{

	public int[] price;

public static void main(String[] args){

Scanner sc = new Scanner(System.in);
System.out.print("No. of days: ");
int n= sc.nextInt();
System.out.println("Enter stock prices for each day:");

StockMaximize stock=new StockMaximize();
stock.price = new int[n];
for(int i=0;i<n;i++){
stock.price[i]=sc.nextInt();
}

System.out.println("Max. profit: " + stock.maxProfit(n,0));

}


int maxProfit(int numDays,int numStocksLeft){
	if(numDays == 0 ){
		//stocks left but no days ahead
		if(numStocksLeft>0) return Integer.MIN_VALUE;
		//neither stocks nor days left
		else return 0;
	}

int profitIfBuy;
if(numStocksLeft == 0) profitIfBuy = Integer.MIN_VALUE;
else profitIfBuy = maxProfit(numDays-1,numStocksLeft-1) - price[numDays-1];
int profitIfSell = maxProfit(numDays-1,numStocksLeft+1) + price[numDays-1];
int profitIfNothing = maxProfit(numDays-1,numStocksLeft);

	return max(profitIfBuy,profitIfSell,profitIfNothing);
}


int max(int a,int b,int c){
	if(a>=b&&a>=c) return a;
	if(b>=a&&b>=c) return b;
	if(c>=a&&c>=b) return c;
	return 0;
}

}



