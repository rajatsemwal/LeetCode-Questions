/*This method uses Kahn's Algorithm to find cycle in a directed Graph. It is quite same to finding the Topo
sort using Kahn's algo, but this is little different from it, like a hack. As we know, Topo Sort exists
only for DAG. So, we check if there exists any cycle, we return true, else false. We acheive this by keeping
the count of nodes we encounter during Topo Sort. At the end of the algo, if the count is equal to the
number of nodes in the graph, we say there's no cycle in the graph(return false), otherwise, we return true.
*/

import java.util.*;

public class GraphCycleDgBFS {
    
    LinkedList<Integer> adj[];

    public GraphCycleDgBFS(int v) {

        adj = new LinkedList[v];

        for(int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices and edges: ");

        int v = sc.nextInt();
        int e = sc.nextInt();

        GraphCycleDgBFS g = new GraphCycleDgBFS(v);

        System.out.println("Enter the edges: ");

        for(int i = 0; i < e; i++) {

            int src = sc.nextInt();
            int des = sc.nextInt();
            g.addedge(src, des);
        }

        if(g.checkCycle(v) == false)
            System.out.println("Graph does not contains cycle!");
        else
            System.out.println("Graph contains cycle!");

        sc.close();
    }

    public void addedge(int src, int des) {
        adj[src].add(des);
    }

    public boolean checkCycle(int v) {

        int[] indegree = new int[v];
        
        for(int i = 0; i < v; i++) {

            for(Integer j: adj[i])
                indegree[j]++;
        }

        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < v; i++) {

            if(indegree[i] == 0)
                q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()) {

            Integer node = q.poll();
            count++;
            
            for(Integer i: adj[node]) {

                indegree[i]--;
                if(indegree[i] == 0)
                    q.add(i);
            }
        }

        if(count == v) return false;

        return true;
    }
}
