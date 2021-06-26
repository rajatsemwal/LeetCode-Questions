/* This Dijsktra's algorithm method uses min-PriorityQueue. There's also another method which uses HashSet.
This algorithm is applied on the Undirected Graph. */

import java.util.*;

class Node implements Comparator<Node> {

    int v;
    int weight;

    Node(int v, int weight) {
        
        this.v = v;
        this.weight = weight;

    }

    Node() {}

    int getW() { return weight; }
    int getV() { return v; }

    /* This compare method sorts the Nodes on the basis of weights of different edges stored in Priority
        Queue. Hence, converting the PQ into an min-PQ. */
    @Override
    public int compare(Node node1, Node node2) {

        if(node1.weight < node2.weight)
            return -1;

        if(node1.weight > node2.weight)
            return 1;

        return 0;
    }
}

public class Dijkstra {
    
    LinkedList<Node> adj[];

    public Dijkstra(int v) {

        adj = new LinkedList[v];

        for(int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices and edges: ");
        int v = sc.nextInt();
        int e = sc.nextInt();

        Dijkstra dks = new Dijkstra(v);

        System.out.println("Enter the edges with their respective weights(source, dest., weight): ");
        for(int i = 0; i < e; i++) {

            int src = sc.nextInt();
            int des = sc.nextInt();
            int wei = sc.nextInt();
            dks.addedge(src, des, wei);
        }

        System.out.print("Enter source from where you want to measure shortest distances to all other nodes: ");
        int src = sc.nextInt();

        int[] ans = dks.shortestPath(v, src);

        System.out.println("The shortest distances from source node " + src + " to all other nodes are: ");
        for(int i = 0; i < v; i++)
            System.out.print(ans[i] + " ");

        System.out.println();

        sc.close();
    }

    public void addedge(int src, int des, int wei) {

        adj[src].add(new Node(des, wei));
        adj[des].add(new Node(src, wei));
    }

    public int[] shortestPath(int v, int src) {

        int[] dis = new int[v];
        Arrays.fill(dis, Integer.MAX_VALUE);
        
        dis[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>(v, new Node());

        pq.add(new Node(src, 0));

        while(!pq.isEmpty()) {

            Node Node = pq.poll();

            for(Node i: adj[Node.getV()]) {

                if(dis[Node.getV()] + i.getW() < dis[i.getV()]) {

                    dis[i.getV()] = dis[Node.getV()] + i.getW();
                    pq.add(new Node(i.getV(), dis[i.getV()]));
                }
            }
        }
        return dis;
    }
}
