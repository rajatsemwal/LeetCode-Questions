/*This program is used to find the Shortest Path in Undirected Graph with Unit Weights, using BFS.*/

import java.util.*;

public class ShortestPath {
    
    LinkedList<Integer> adj[];

    public ShortestPath(int v) {

        adj = new LinkedList[v];

        for(int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter no. of vertices and edges: ");

        int v = sc.nextInt();
        int e = sc.nextInt();

        ShortestPath sp = new ShortestPath(v);

        System.out.println("Enter the edges: ");

        for(int i = 0; i < e; i++) {

            int src = sc.nextInt();
            int des = sc.nextInt();
            sp.addedge(src, des);
        }

        System.out.print("Enter the source vertex: ");
        int source = sc.nextInt();

        System.out.println("The shortest distances from source node " + source + " to all other nodes is: ");
        sp.sPath(v, source);

        sc.close();
    }

    public void addedge(int src, int des) {

        adj[src].add(des);
        adj[des].add(src);
    }

    public void sPath(int v, int src) {

        int[] dist = new int[v];
        for(int i = 0; i < v; i++)
            dist[i] = Integer.MAX_VALUE;

        Queue<Integer> q = new LinkedList<>();

        dist[src] = 0;
        q.add(src);

        while(!q.isEmpty()) {

            int node = q.poll();

            for(Integer i: adj[node]) {

                if(dist[node] + 1 < dist[i]) {

                    dist[i] = dist[node] + 1;
                    q.add(i);
                }
            }
        }

        for(int i: dist)
            System.out.print(i + " ");
        
        System.out.println();
    }
}
