/*This Topological sort is done here using BFS. One imoportant thing to note here is that the Topological
sort only works on a DAG(Directed Acyclic Graph). If in any case, you are not sure whether the input 
conatins cycle or not, you must check it before finding Topo Sort of that graph.
The BFS Topological sort algorithm is also called Kahn's Algorithm. */


import java.util.*;

public class TopologicalSortBFS {
    
    LinkedList<Integer> adj[];

    public TopologicalSortBFS(int v) {

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

		TopologicalSortBFS ts = new TopologicalSortBFS(v);

		System.out.println("Enter " + e + " edges: ");
		
        for(int i = 0; i < e; i++) {
			int src = sc.nextInt();
			int des = sc.nextInt();
			ts.addedge(src, des);
		}

        ArrayList<Integer> ans = ts.topoSort(v);

        System.out.println(ans);

        sc.close();

    }

    void addedge(int src, int des) {

		adj[src].add(des);
	}

    public ArrayList<Integer> topoSort(int v) {

        ArrayList<Integer> sorted = new ArrayList<>();
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
        
        while(!q.isEmpty()) {

            Integer node = q.poll();
            sorted.add(node);

            for(Integer i: adj[node]) {

                indegree[i]--;
                if(indegree[i] == 0)
                    q.add(i);
            }
        }
        
        return sorted;
    }
}
