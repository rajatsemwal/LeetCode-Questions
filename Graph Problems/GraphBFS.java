/* This code shows the implementation of Graph and also the BFS traversal. 
Not any LeetCode ques, but you should know it.
*/

import java.util.*;

public class GraphBFS {

	LinkedList<Integer> adj[];

	GraphBFS(int v) {
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addedge(int src, int des) {
		adj[src].add(des);
		adj[des].add(src);
	}

	public ArrayList<Integer> bfs(int v) {

		boolean[] vis = new boolean[adj.length];
		
		ArrayList<Integer> ans = new ArrayList<>();

		for(int i = 0; i < v; i++) {

			if(vis[i] == false) {

				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				vis[i] = true;

				while(!q.isEmpty()) {

					int start = q.poll();
					ans.add(start);
		
					for(int nei: adj[start]) {
						if(vis[nei] == false) {
							vis[nei] = true;
							q.add(nei);
						}
					}
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of vertices and edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		GraphBFS g = new GraphBFS(v);

		System.out.println("Enter " + e + " edges: ");
		for(int i = 0; i < e; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			g.addedge(src, des);
		}

		ArrayList<Integer> trav = g.bfs(v);
		
		System.out.print("The BFS traversal is: ");
		for(int i = 0; i < trav.size(); i++)
			System.out.print(trav.get(i) + " ");
		
			System.out.println();
		
		sc.close();
	}
}