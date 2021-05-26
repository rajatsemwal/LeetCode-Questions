/* This cycle detection is done using BFS.
This is not any LeetCode ques, but you should know how detect cycle in an Undirected Graph using BFS. */

import java.util.*;

class GraphCycleUgBFS {

	LinkedList<Integer> adj[];

	GraphCycleUgBFS(int v) {
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++) 
			adj[i] = new LinkedList<>();
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of vertices and edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		GraphCycleUgBFS g = new GraphCycleUgBFS(v);

		System.out.println("Enter " + e + " edges: ");
		for(int i = 0; i < e; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			g.addedge(src, des);
		}

		// addedge(adj, 0, 1);   		/*Contains Cycle*/
		// addedge(adj, 1, 2); 
   		// addedge(adj, 2, 0); 
  	   	// addedge(adj, 2, 3);


		// addedge(adj, 0, 1);		/*Does not contains cycle*/
		// addedge(adj, 1, 2);
		// addedge(adj, 2, 3);

		if(g.isCyclicExist(v))
			System.out.println("Yes, the cycle exists!");
		else
			System.out.println("No, the cycle does not exist!");
		sc.close();
	}

	public void addedge(int u, int v) {

		adj[u].add(v);
		adj[v].add(u);
	}

	public boolean isCyclicExist(int v) {

		boolean[] visited = new boolean[v];

		for(int i = 0; i < v; i++) {

			if(visited[i] == false && isCyclicBFS(i, visited, v))
				return true;
		}
		return false;
	}

	public boolean isCyclicBFS(int s, boolean[] visited, int v) {

		int[] parent = new int[v];
		Arrays.fill(parent, -1);

		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.add(s);

		while(!q.isEmpty()) {

			int u = q.poll();
			for(int i = 0; i < adj[u].size(); i++) {

				int cur = adj[u].get(i);
				if(visited[cur] != true) {

					visited[cur] = true;
					q.add(cur);
					parent[cur] = u;
				}
				else if(parent[u] != cur)
					return true;
			}
		}
		return false;
	}
}