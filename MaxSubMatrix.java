class Solution{
	
	/*
	public static int maxSubMatrix(int[][] matrix){
		int numRows = matrix.length;
		int numCols = matrix[0].length;

		//iterate for left bound of req. sub matrix
		for(int left=0;left<numCols;left++){
			int[] temp = new int[numRows];
			//iterate for right bound of req. sub matrix
			for(int right=left;right<numCols;right++){
				
				for(int i=0;i<numRows;i++){
					//sum of each row from leftcolumn = left to rightcolumn = right
					temp[i] += matrix[i][right];
				}
				//now find max. sum subarray of temp with O(n) Kadane's algorithm.
				int max = maxSubArray(temp);

			}
		}
	}
	*/

//Kadane's Algorithm. Complexity: O(n)
	public static int maxSubArraySum(int[] arr){
		int finalMax=0,currMax=0;
		for(int i=0;i<arr.length;i++){
			currMax+=arr[i];
			if(currMax < 0) currMax = 0;
			else if(currMax > finalMax) finalMax = currMax;
		}
		return finalMax;
	}


//All positive elements. Max sum subarray 
//consisting of <= l elements
//Since all positive, the subarray should always be of size l
//no need to take lower size
	public static int maxSubArraySum(int[] arr, int l){
		int max=0,i=0;
		//initialise max as sum of first l elements
		for(;i<l;i++){
			max+=arr[i];
		}
		int sum_ending_here = max;
		//iterate the block forward
		for(;i<arr.length;i++){
			sum_ending_here += (arr[i]-arr[i-l]);
			//update max if sum of this block is larger
			if(sum_ending_here > max) max = sum_ending_here;
		}

		return max;
	}


	public static int maxSubMatrixSum(int[][] m, int l){
		int max=0,i=0,j=0;
		//initialise max as sum of first l sized submatrix
		for(;i<l;i++){
			for(;j<l;j++){
				max+=m[i][j];
			}
		}
		int sum_ending_here = max;
		//iterate the block forward
		for(;i<arr.length;i++){
			sum_ending_here += (arr[i]-arr[i-l]);
			//update max if sum of this block is larger
			if(sum_ending_here > max) max = sum_ending_here;
		}

		return max;
	}

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,6,7};

		System.out.println("Max sub array sum is: " + maxSubArraySum(arr,3));
	}

}