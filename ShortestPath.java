
import java.io.*;
import java.util.*;
 
// This class represents a undirected graph using adjacency list
// representation
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    private int distance[];
 
    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v+1];
        for (int i=0; i<adj.length; ++i)
            adj[i] = new LinkedList();
    }
 
    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }
 
    // computes shortest path of each vertex from vertex s using BFS
    int[] shortestPathBFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V+1];
        distance = new int[V+1];
        for(int i=0;i<distance.length;i++){
        	distance[i] = -1;
        }
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s]=true;
        distance[s]=0;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            //System.out.print(s+" ");
 
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
                    //cost of each edge is 6 units
                    distance[n] = distance[s] + 6;
                    queue.add(n);
                }
            }
        }
        return distance;
    }
}

class Solution{
	
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num of test cases: ");
    	int t =sc.nextInt();
    	while(t-- > 0){
    		System.out.print("No. of vertices? ");
    		int n =sc.nextInt();
    		Graph graph = new Graph(n);

    		System.out.print("No.of edges? ");
    		int m = sc.nextInt();
    		for(int i=0;i<m;i++){
    			graph.addEdge(sc.nextInt(),sc.nextInt());
    		}

            int s = sc.nextInt();
    		int[] distance = graph.shortestPathBFS(s);
    		for(int i=1;i<distance.length;i++){
                if(i!=s)
    			System.out.print(distance[i]+" ");
    		}
    		System.out.println();

    	}
    }

}