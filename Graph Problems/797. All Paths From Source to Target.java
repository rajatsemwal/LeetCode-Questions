/*This method uses DFS to get all the possible paths from source node to target node. In this ques, 0 or 0th index is the source node and
  the last index of the graph array is the target node.*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        
        cur.add(0);
        
        dfs(0, graph.length - 1, graph, ans, cur);
        
        return ans;
    }
    
    public void dfs(int src, int des, int[][] graph, List<List<Integer>> ans, List<Integer> cur) {
        
        if(src == des) {
            ans.add(new ArrayList(cur));
            return;
        }
            
        
        for(int i: graph[src]) {
            
            cur.add(i);
            dfs(i, des, graph, ans, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
