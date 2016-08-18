// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.io.*;
import java.util.*;
 

class Node{
    public Integer data;
    public Node next;
}

class Stack{
    public Node bottom;
    public Node top;
    
    void Stack(){
        top = null;
        bottom=null;
    }
    
    public void push(Integer data){
        Node newNode = new Node();
        newNode.data=data;
        newNode.next = top;
        if(top==null) bottom = newNode;
        top = newNode;
    }
    
    public Integer pop(){
        if(isEmpty()){
            return null;
        }
        Integer data = top.data;
        top = top.next;
        return data;
    }
    
    public boolean isEmpty(){
        return top==null;
    }
    
    public void popStack(){
        while(!isEmpty()){
            Integer data = pop();
            System.out.println(data.intValue());
        }
    }
    
}


// This class represents a directed graph using adjacency list
// representation
class GraphAdjList
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
 
    // Constructor
    GraphAdjList(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }
 
    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

 
    // Driver method to
    public static void main(String args[])
    {
        GraphAdjList g = new GraphAdjList(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.BFS(2);
    }
}


class GraphAdjMatrix{
	private int V;   // No. of vertices
    private int adjMatrix[][]; //Adjacency matrix
 
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
    void addEdge(int v,int w,int cost)
    {
        adjMatrix[v][w] = cost;
    }
 
    
    //prints dfs traversal from source vertex s(adj. matrix representation)
    void dfsUtil(int s){
    	boolean[] visited = new boolean[V];
    	dfs(s,visited);
    }

    void customStackDFS(int s){
        
        boolean[] visited = new boolean[V];
        Stack stack = new Stack();
        stack.push(new Integer(s));

        while(!stack.isEmpty()){
            int currVertex = stack.pop().intValue();
            System.out.print(currVertex + " ");
            visited[currVertex] = true;
            for(int i=V-1;i>-1;i--){
                if(adjMatrix[currVertex][i] > 0 && !visited[i])  stack.push(new Integer(i));
            }
        }

    }

    void dfs(int s, boolean[] visited){
    	//mark this vertex as visited
    	visited[s] = true;
    	System.out.print(s + " ");

    	//recur for all adjacent vertices
    	for(int i=0;i<V;i++){
    		if(adjMatrix[s][i] > 0 && !visited[i])  dfs(i,visited);
    	}
    }

    void cycleDetectUtil(int s){
        //boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        int[] pred = new int[V];
        for(int i=0;i<V;i++){
            pred[i] = -1;
        }
        cycleDetect(s,recStack,pred);
    }

//Cycle detection using dfs
    void cycleDetect(int s, boolean[] recStack, int[] pred){
        //mark vertex as visited and part of rec stack
        //visited[s] = true;
        recStack[s] = true;

        for(int i=0;i<V;i++){
            //if edge between s and i present
            if(adjMatrix[s][i] > 0){
                //mark s as predecessor of i in current recursive stack
                System.out.println("Processing edge (" + s +"," + i +")");
                pred[i] = s;
                //if vertex part of recursive stack
                if(recStack[i]){
                    int x=i;
                    int count =1;
                    //go up recursive stack and compute cycle length
                    while(pred[x] != i){
                        x=pred[x];
                        count++;
                    }
                    System.out.println("Cycle detected at " + i + ".Length: " + count);
                }
                //if vertex i not already visited
                //if(!visited[i])
                    else cycleDetect(i,recStack,pred);

                pred[i]= -1;
            }
        }
        //remove current vertex from rec stack
        recStack[s] = false;
        return;
    }


    // Driver method to
    public static void main(String args[])
    {
    	int[][] matrix = {
	    	{0, 1, 0, 0, 0},
			{0, 0, 1, 1, 0},
			{1, 0, 0, 0, 0},
			{0, 0, 0, 1, 0},
			{0, 0, 0, 0, 0}};

        /*GraphAdjMatrix g = new GraphAdjMatrix(7);
 
        g.addEdge(0, 6, 1);
        g.addEdge(6, 1, 1);
        g.addEdge(1, 2, 1);
        g.addEdge(1, 5, 1);
        g.addEdge(2, 3, 1);
        g.addEdge(2, 4, 1);
        g.addEdge(3, 1, 1);
        g.addEdge(4, 4, 1);
        */

GraphAdjMatrix g = new GraphAdjMatrix(4);
        g.addEdge(0, 1,1);
    g.addEdge(0, 2,1);
    g.addEdge(1, 2,1);
    g.addEdge(2, 0,1);
    g.addEdge(2, 3,1);
    g.addEdge(3, 3,1);


        int s = 0;
        System.out.println("DFS traversal cycle detection " +
                           "starting from vertex " + s);

        g.cycleDetectUtil(s);
    }

}