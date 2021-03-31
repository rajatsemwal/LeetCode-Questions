class Solution {

    List<Integer>[] adj;
    Stack<Integer> stack;
    boolean[] visited;
    boolean[] explored;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        adj = new ArrayList[numCourses];
        stack = new Stack<>();
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();
        
        for(int i = 0; i < prerequisites.length; i++)
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(isCyclic(i))
                    return new int[]{};
            }
        }    
        
        visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i])
                topological(i);
        }
        
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.pop();
        
        return res;
    }
    
    public boolean isCyclic(int i) {
        
        visited[i] = true;
        for(int j: adj[i]) {
            if(!visited[j]) {
                if(isCyclic(j))
                    return true;
            }
            else if(!explored[j])
                return true;
        }
        
        explored[i] = true;
        return false;
    }
    
    public void topological(int i) {
        
        visited[i] = true;
        for(int j: adj[i]) {
            if(!visited[j])
                topological(j);
        }
        stack.push(i);
    }
}
