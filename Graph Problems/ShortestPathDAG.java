/*This method uses topological sort to find the shortest path between nodes in a DAG. Its always better to
choose the starting node as the source node to better visualize and understand it.
If you are a beginner and doing it for the first time, try to do it on a notebook for better understanding.
It is recommended for all the graph concepts and problems!*/

import java.util.*;

// A Pair class is made to store a vertex's adjacent node and weigth associated with the edge.
class Pair {

    int v; //adjacent vertex
    int weight; //weight associated with the corresponding edge

    Pair(int v, int weight) {
        this.v = v;
        this.weight = weight;
    }

    //Getter method to get the adjacent vertex
    int getV() {
        return v;
    }

    //getter method to get weight of the edge
    int getW() {
        return weight;
    }
}

public class ShortestPathDAG {

    LinkedList<Pair> adj[];

    public ShortestPathDAG(int v) {

        adj = new LinkedList[v];

        for(int i = 0; i < v; i++) 
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices and edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        ShortestPathDAG spdag =  new ShortestPathDAG(v);

        System.out.println("Enter the edges with their weights: ");
        for(int i = 0; i < e; i++) {

            int src = sc.nextInt();
            int des = sc.nextInt();
            int wei = sc.nextInt();
            spdag.addedge(src, des, wei);
        }

        System.out.print("Enter the source vertex: ");
        int source = sc.nextInt();

        System.out.print("The shortest path from source node " + source + " is: ");
        int[] res = spdag.shortestPath(v, source);

        for(int i = 0; i < v; i++) {
            if(res[i] == Integer.MAX_VALUE)
                System.out.print("Infinity" + " ");
            else
                System.out.print(res[i] + " ");
        }
        System.out.println();

        sc.close();
            
    }

    public void addedge(int src, int des, int wei) {
        adj[src].add(new Pair(des, wei));
    }

    public int[] shortestPath(int v, int src) {

        Stack<Integer> stack = new Stack<>();
        int[] dis = new int[v];
        boolean[] vis = new boolean[v];

        for(int i = 0; i < v; i++) {

            if(vis[i] == false) {
                topoSort(i, vis, stack);
            }
        }

        for(int i = 0; i < v; i++)
            dis[i] = Integer.MAX_VALUE;

        dis[src] = 0;

        while(!stack.isEmpty()) {

            int node = (int)stack.pop();

            if(dis[node] != Integer.MAX_VALUE) {

                for(Pair i: adj[node]) {

                    if(dis[node] + i.getW() < dis[i.getV()])
                        dis[i.getV()] = dis[node] + i.getW();
                }
            }
        }

        return dis;
    }

    public void topoSort(int node, boolean[] vis, Stack<Integer> stack) {

        vis[node] = true;

        for(Pair i: adj[node]) {

            if(vis[i.getV()] == false)
                topoSort(i.getV(), vis, stack);
        }
        stack.push(node);
    }
}
