/* This code shows the implementation of graph and also shows the DFS traversal.
Not any LeetCode ques, but you should know it.
*/

import java.util.*;

public class GraphDFS {

	LinkedList<Integer> adj[];

	GraphDFS(int v) {
		adj = new LinkedList[v];
		for(int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	public void addedge(int src, int des) {
		adj[src].add(des);
		adj[des].add(src);
	}

    public void dfsutil(int source, boolean[] vis, ArrayList<Integer> ans) {

		ans.add(source);
        vis[source] = true;

		for(int nei: adj[source]) {
			
			if(vis[nei] == false) {
				vis[nei] = true;
				dfsutil(nei, vis, ans);
			}
		}
	}

	public void dfstack(int source) {
		boolean[] vis = new boolean[adj.length];
		vis[source] = true;
		System.out.println(source + " ");

		Stack<Integer> stack = new Stack<>();
		stack.push(source);

		while(!stack.isEmpty()) {
			source = stack.pop();

			for(int nei: adj[source]) {
				if(vis[nei] == false) {
					vis[nei] = true;
					stack.push(nei);
				}
			}
		}
	}

	public ArrayList<Integer> dfs(int v) {

		boolean[] vis = new boolean[v];
        ArrayList<Integer> ans = new ArrayList<>();

		for(int i = 0; i < v; i++) {
			if(vis[i] == false)
				dfsutil(i, vis, ans);	
		}
        return ans;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of vertices and edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		GraphDFS g = new GraphDFS(v);

		System.out.println("Enter " + e + " edges: ");
		for(int i = 0; i < e; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			g.addedge(src, des);
		}

		ArrayList<Integer> trav = g.dfs(v);
		
		System.out.print("The DFS traversal is: ");
		for(int i = 0; i < trav.size(); i++)
			System.out.print(trav.get(i) + " ");
		
			System.out.println();
		
		sc.close();
	}
}