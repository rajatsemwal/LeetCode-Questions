class Solution {
    
    List<Integer>[] adj;
    boolean[] visited;
    boolean[] explored;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        adj = new ArrayList[numCourses];
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<>();
        
        for(int i = 0; i < prerequisites.length; i++)
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        
        for(int i = 0; i < numCourses; i++) {
            if(!visited[i]) {
                if(isCyclic(i))
                    return false;
            }
        }
        return true;
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
}
