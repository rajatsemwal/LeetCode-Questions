/*This, Graph Bipartite is done, using DFS*/

import java.util.*;

public class BipartiteDFS {
    
    LinkedList<Integer> adj[];

    public BipartiteDFS(int v) {

        adj = new LinkedList[v];

        for(int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of vertices and edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		BipartiteDFS g = new BipartiteDFS(v);

		System.out.println("Enter " + e + " edges: ");
		for(int i = 0; i < e; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			g.addedge(src, des);
		}

        if(g.checkBipartite(v))
            System.out.println("Yes, the graph is Bipartite!");
        else
            System.out.println("No, the graph is not Bipartite!");

        sc.close();
    }
 
    public void addedge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public boolean checkBipartite(int v) {

        int[] color = new int[v];
        for(int i = 0; i < v; i++)
            color[i] = -1;

        for(int i = 0; i < v; i++) {

            if(color[i] == -1) {

                if(!checkDFS(i, color))
                    return false;
            }
        }

        return true;
    }

    public boolean checkDFS(int node, int[] color) {

        if(color[node] == -1)
            color[node] = 1;

        for(Integer i: adj[node]) {

            if(color[i] == -1) {
                color[i] = 1 - color[node];

                if(!checkDFS(i, color))
                    return false;
            }
            else if(color[node] == color[i])
                return false;
        }

        return true;
    }
}
