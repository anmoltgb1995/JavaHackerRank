import java.util.*;

class Solution{

	private static final Scanner sc = new Scanner(System.in);
	static int n,a[];

	public static void main(String[] args){
		int t = sc.nextInt();
		while(t-- > 0){
			inputArray();
			//printArray();

			//currPathCounter is taken negative to
			//differentiate from legal array values
			int currPathCounter = -1,magicBoxes=0,boxesVisited=0;

			//loop until all boxes visited
			while(boxesVisited < n){
				//find a not-yet-visited box
				int i=0;
				for(;i<n && a[i]<0 ;i++);

				boxesVisited++;
				int currBox = i;
				int start = currPathCounter;
				//traverse path from this box till
				//it reaches a box in the same path
				//or a previously traversed path
				while(true){
					int nextBox = (currBox+a[currBox]+1)%n;
					//set current box as part of current path
					a[currBox] = currPathCounter--;

					//if reached box from current path
					//mark all boxes in the path AFTER
					//that box as magical
					//those BEFORE that box are not magical
					if(a[nextBox] <= start){
						magicBoxes+= (-1)*(currPathCounter-a[nextBox]);
						break;
					}
					//else if reached box from some
					//previous path, all boxes in this
					//path are non-magical
					else if(a[nextBox]> start && a[nextBox]<0)
					break;
					//else if reached a not-yet-visited
					//box
					else{
						boxesVisited++;
						//currPathBoxes++;
						//repeat loop for next box
						currBox = nextBox;
					}

				}

			}

			System.out.println("Total magic boxes: "+magicBoxes);
			//System.out.println(magicBoxes);

		}
	}

	private static void inputArray(){
			n=sc.nextInt();
			a = new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
	}

	private static void printArray(){
		System.out.println("Array length: "+a.length);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
	}
 
} 