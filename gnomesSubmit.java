import java.util.*;

class GraphAdjMatrix{
	private int V;   // No. of vertices
    private int adjMatrix[][]; //Adjacency matrix
    private boolean[] kLevelVertices;
    private int count;

    int getCount(){ return count;}
 
    // Constructor
    GraphAdjMatrix(int v)
    {
        V = v;
        adjMatrix = new int[v][v];
    }

    GraphAdjMatrix(int v, int[][] matrix)
    {
        V = v;
        adjMatrix = matrix;
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adjMatrix[v][w] = 1;
    }

    void addEdge(int v,int w,int cost)
    {
        adjMatrix[v][w] = cost;
    }
 
    
    void dfsUtil(int x, int k){
    	//boolean[] visited = new boolean[V];
    	dfs(x,0,k);
    }

    void dfs(int x, int currDepth, int k){
    	//System.out.println("Visiting " + (x+1)+ ". Depth= " + currDepth);
    	if(currDepth == k){
    		//reached depth k
	    	System.out.println( (x+1) + " ");
	    	return;
	    }

    	//recur for all adjacent vertices
    	for(int i=0;i<V;i++){
    		if(adjMatrix[x][i] == 1)  dfs(i,currDepth+1, k);
    	}
    }


    boolean[] kLevelGnomes(int k,int s){
        //boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        this.kLevelVertices = new boolean[V];
        int[] pred = new int[V];
        this.count=0;
        for(int i=0;i<V;i++){
            pred[i] = -1;
        }
        cycleDetect(s,0,k,recStack,pred);
        return kLevelVertices;
    }

//Cycle detection using dfs
    void cycleDetect(int s, int currDepth,int k,boolean[] recStack, int[] pred){
        //mark vertex as visited
        //visited[s] = true;

        //System.out.println("Current depth: "+ currDepth);

        //if reached depth k, dont process this path further
        if(currDepth == k){
            //System.out.println( "Reached depth " + k + " at vertex " + (s));
            if(!kLevelVertices[s]){
                kLevelVertices[s] = true;
                count++;
            }
            return;
        }
        //mark vertex as part of rec stack
        recStack[s] = true;

        for(int i=0;i<V;i++){
            //if edge between s and i present
            if(adjMatrix[s][i] > 0){
                
                //mark s as predecessor of i in current recursive stack
                pred[i] = s;
                //if vertex part of recursive stack
                if(recStack[i]){
                    
                    int x=i;
                    int len = 1;
                    //go up recursive stack and compute cycle length
                    while(pred[x] != i){
                        x=pred[x];
                        len++;
                    }
                    int fwdSteps = (k-(currDepth+1))%len;
                    //System.out.println("Cycle detected at " + i + ".Length: " + len);
                    int d=0;
                    if(fwdSteps==0) d=i;
                    else{
                        d=i;
                        int backSteps = len - fwdSteps;
                        //System.out.println("Backing up " + backSteps + " from vertex " + i);
                        for(int j=0;j<backSteps;j++){
                            d=pred[d];
                        }
                    }
                    if(!kLevelVertices[d]){
                        kLevelVertices[d] = true;
                        count++;
                    }
                    //System.out.println("Vertex at depth " + k + " in this cycle: " + d);
                    
                }
                //if vertex i not already visited
                //if(!visited[i])
                    else cycleDetect(i,currDepth+1,k,recStack,pred);

                pred[i]= -1;
            }
        }
        //remove current vertex from rec stack
        recStack[s] = false;
        return;
    }


}

class Solution{
	
	public static void main(String args[])
    {
        /*
int V=4;
        GraphAdjMatrix g = new GraphAdjMatrix(V);
        g.addEdge(0, 1,1);
    g.addEdge(0, 2,1);
    g.addEdge(1, 2,1);
    g.addEdge(2, 0,1);
    g.addEdge(2, 3,1);
    g.addEdge(3, 3,1);
    
    	int[][] matrix = {
	    	{0, 1, 0, 0, 0},
			{0, 0, 1, 1, 0},
			{1, 0, 0, 0, 0},
			{0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0}};
*/
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter num vertices: ");
        int V = sc.nextInt();
        int[][] matrix = new int[V][V];
        //System.out.println("Enter adjacenecy matrix: ");
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        GraphAdjMatrix g = new GraphAdjMatrix(V,matrix);
        //System.out.print("Enter m: ");
        int m = sc.nextInt();
        while(m-- > 0){
            //System.out.println("\nEnter k,x: ");
            //int k = 1;
            //int x = 5;
            int k = sc.nextInt();
            int x = sc.nextInt();
 
            boolean[] arr = g.kLevelGnomes(k,x-1);
            int count = g.getCount();
            if(count == 0){ System.out.println("-1"); continue; }
            System.out.println(count);
            for(int i =0;i<V;i++){
                if(arr[i]) System.out.print( (i+1) + " ");
            }
            System.out.println();
        }

    }

}