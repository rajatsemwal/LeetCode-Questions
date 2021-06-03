/* This cycle detection is done using DFS.
This is not any LeetCode ques, but you should know how to detect cycle in an Undirected Graph using DFS. */

import java.util.*;

class GraphCycleUgDFS {

	LinkedList<Integer> adj[];
	
	public GraphCycleUgDFS(int v) {

		adj = new LinkedList[v];
		for(int i = 0; i < v; i++)
			adj[i] = new LinkedList<>();
	}

	void addedge(int u, int v) {
		adj[u].add(v);
		adj[v].add(u);
	}

	boolean isCyclic(int v) {

		boolean[] visited = new boolean[v];

		for(int i = 0; i < v; i++) {

			if(visited[i] != true) {
				if(isCyclicUtil(adj, i, -1, visited))
					return true;
			}
		}

		return false;
	}

	boolean isCyclicUtil(LinkedList<Integer> adj[], int source, int parent, boolean[] visited) {

		visited[source] = true;
		
		for(int j: adj[source]) {

			if(visited[j] != true) {

				if(isCyclicUtil(adj, j, source, visited))
					return true;
			}
			else if(j != parent)
				return true;
		}

		return false;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of vertices and edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		GraphCycleUgDFS g = new GraphCycleUgDFS(v);

		System.out.println("Enter " + e + " edges: ");
		for(int i = 0; i < e; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			g.addedge(src, des);
		}

		if(g.isCyclic(v))
			System.out.println("Graph contains cycle!");

		else
			System.out.println("Graph does not contains cycle!");

		sc.close();


		/*Test cases*/ 

		// g.add_edge(1, 0); 		/*Contains cycle*/
        // g.add_edge(0, 2); 
        // g.add_edge(2, 1); 
        // g.add_edge(0, 3);
        // g.add_edge(3, 4); 


        // g.add_edge(0, 1); 		/*Does not contain cycle*/
        // g.add_edge(1, 2); 

	}
}
