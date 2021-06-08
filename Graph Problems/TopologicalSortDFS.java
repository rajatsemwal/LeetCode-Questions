/*This Topological sort is done here using DFS. One imoportant thing to note here is that the Topological
sort only works on a DAG(Directed Acyclic Graph). If in any case, you are not sure whether the input 
conatins cycle or not, you must check it before finding Topo Sort of that graph.*/

import java.util.*;

public class TopologicalSortDFS {
    
    LinkedList<Integer> adj[];

    public TopologicalSortDFS(int v) {

        adj = new LinkedList[v];

        for(int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("You must enter a graph which should not contain any cycle!");

		System.out.print("Enter number of vertices and edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		TopologicalSortDFS ts = new TopologicalSortDFS(v);

		System.out.println("Enter " + e + " edges: ");
		
        for(int i = 0; i < e; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			ts.addedge(src, des);
		}

        ArrayList<Integer> ans = ts.topoSort(v);

        System.out.println("The Topological sort of the graph is: " + ans);
        //System.out.print(ans);

        sc.close();
    }

    void addedge(int src, int des) {

		adj[src].add(des);
	}

    public ArrayList<Integer> topoSort(int v) {

        Stack<Integer> stack = new Stack<Integer>();
        boolean[] vis = new boolean[v];

        for(int i = 0; i < v; i++) {

            if(vis[i] == false) {
                checkDFS(i, vis, stack);
            }
        }

        ArrayList<Integer> sorted = new ArrayList<>();

        while(!stack.isEmpty()) {

            sorted.add(stack.pop());
        }

        return sorted;
    }

    public void checkDFS(int node, boolean[] vis, Stack<Integer> stack) {

        vis[node] = true;

        for(Integer i: adj[node]) {
            if(vis[i] == false)
                checkDFS(i, vis, stack);
        }
        stack.push(node);
    }
}