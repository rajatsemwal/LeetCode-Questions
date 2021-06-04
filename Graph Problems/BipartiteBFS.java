/*This, Graph Bipartite is done, using BFS*/

import java.util.*;

class BipartiteBFS {

    LinkedList<Integer> adj[];

    public BipartiteBFS(int v) {

        adj = new LinkedList[v];
        
        for(int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of vertices and edges: ");
		int v = sc.nextInt();
		int e = sc.nextInt();

		BipartiteBFS g = new BipartiteBFS(v);

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

                if(!bfsCheck(i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean bfsCheck(int node, int[] color) {

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        color[node] = 1;

        while(!q.isEmpty()) {

            Integer nde = q.poll();

            for(Integer newnode: adj[nde]){
                if(color[newnode] == -1) {
                    color[newnode] = 1 - color[nde];
                    q.add(newnode);
                }
                else if(color[newnode] == color[nde])
                    return false;
            }
        }
        
        return true;
    }
}